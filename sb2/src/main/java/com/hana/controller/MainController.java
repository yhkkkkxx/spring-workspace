package com.hana.controller;

import com.hana.app.data.dto.AddrDto;
import com.hana.app.data.dto.CustDto;
import com.hana.app.service.AddrService;
import com.hana.app.service.CustService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.tags.shaded.org.apache.xpath.operations.Mod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@Slf4j
@RequiredArgsConstructor
public class MainController {
    final CustService custService;

    @RequestMapping("/")
    public String main() {
        return "index";
    }
    @RequestMapping("/login")
    public String login(Model model) {
        model.addAttribute("center", "login");
        return "index";
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
            log.info("------------------------");
            log.info(httpSession.getAttribute("id").toString());
            log.info("------------------------");
        } catch (Exception e) {
            model.addAttribute("center", "loginfail");
            //throw new RuntimeException(e);
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


}
