package com.hana.controller;

import com.hana.app.data.dto.AddrDto;
import com.hana.app.data.dto.BoardDto;
import com.hana.app.data.dto.CustDto;
import com.hana.app.service.AddrService;
import com.hana.app.service.BoardService;
import com.hana.app.service.CustService;
import com.hana.util.WeatherUtil;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.tags.shaded.org.apache.xpath.operations.Mod;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.List;
import java.util.Random;

@Controller
@Slf4j
@RequiredArgsConstructor
public class MainController {
    final CustService custService;
    final BoardService boardService;

    @Value("${app.key.wkey}")
    String wkey;
    @Value("${app.key.whkey}")
    String whkey;
    @Value("${app.url.serverurl}")
    String serverurl;

    @RequestMapping("/")
    public String main(Model model) {
        Random r = new Random();
        int num = r.nextInt(1000)+1;
        List<BoardDto> list = null;
        try{
            list = boardService.getRank();
        }catch (Exception e){
            model.addAttribute("ranks",null);
        }
        model.addAttribute("ranks",list);
        return "index";
    }
    @RequestMapping("/login")
    public String login(Model model) {
        model.addAttribute("center", "login");
        return "index";
    }
    @RequestMapping("/wh")
    @ResponseBody
    public Object wh(Model model) throws IOException, ParseException {
        return WeatherUtil.getWeather("109", wkey);
    }
    @RequestMapping("/logout")
    public String logout(Model model, HttpSession httpSession) {
        if(httpSession != null) {
            httpSession.invalidate();
        }
        return "index";
    }
    @RequestMapping("/loginimpl")
    public String loginimpl(Model model, @RequestParam("id") String id, @RequestParam("pwd") String pwd, HttpSession httpSession) {
        log.info("----------------------------------");
        log.info(id+" "+pwd);

        CustDto custDto = null;
        try {
            custDto = custService.get(id);
            if(custDto == null) {
                throw new Exception();
            }
            if(!custDto.getPwd().equals(pwd)) {
                throw new Exception();
            }
            httpSession.setAttribute("id", id);
            return "redirect:/";
        } catch (Exception e) {
            model.addAttribute("msg","ID또는 PWD가 틀렸습니다.");
            model.addAttribute("center","login");
        }
        return "index";
    }
    @RequestMapping("/register")
    public String register(Model model) {
        model.addAttribute("center", "register");
        return "index";
    }
    @RequestMapping("/registerimpl")
    public String registerimpl(Model model, CustDto custDto, HttpSession httpSession) {
        try {
            custService.add(custDto);
            httpSession.setAttribute("id", custDto.getId());
        } catch (Exception e) {
//            throw new RuntimeException(e);
            model.addAttribute("center", "registerfail");
        }
        return "index";
    }

    @ResponseBody
    @RequestMapping("/registercheckid")
    public Object registercheckid(@RequestParam("id") String id) throws Exception {
        String result = "0";
        CustDto custDto = custService.get(id);
        if(custDto == null){
            result = "1";
        }
        return result;
    }

    @RequestMapping("/weather")
    public String weather(Model model) throws IOException, ParseException {
        model.addAttribute("center", "weather");
        return "index";
    }
    @RequestMapping("/wh2")
    @ResponseBody
    public Object wh2(Model model) throws IOException, ParseException {
        return WeatherUtil.getWeather2("1835848", whkey);
    }
    @RequestMapping("/chat")
    public String chat(Model model) {
        model.addAttribute("serverurl", serverurl);
        model.addAttribute("center", "chat");
        return "index";
    }

}
