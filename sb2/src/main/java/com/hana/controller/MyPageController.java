package com.hana.controller;

import com.hana.app.data.dto.AddrDto;
import com.hana.app.data.dto.CustDto;
import com.hana.app.service.AddrService;
import com.hana.app.service.CustService;
import com.sun.tools.jconsole.JConsoleContext;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.tags.shaded.org.apache.xpath.operations.Mod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/mypage")
@RequiredArgsConstructor
@Slf4j
public class MyPageController {
    String dir = "mypage/";
    final CustService custService;
    final AddrService addrService;

    @RequestMapping("/")
    public String main(Model model, HttpSession httpSession) {
        CustDto custDto = null;
        String id = httpSession.getAttribute("id").toString();
        try {
            custDto = custService.get(id);
            log.info(custDto.getId());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        model.addAttribute("myinfo", custDto);
        model.addAttribute("left", dir+"left");
        model.addAttribute("center", dir+"center");
        return "index";
    }

    @RequestMapping("/address")
    public String address(Model model, HttpSession httpSession) {
        String custid = httpSession.getAttribute("id").toString();
        List<AddrDto> addrlist = new ArrayList<>();
        try {
            addrlist = addrService.getAddress(custid);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        model.addAttribute("addrlist", addrlist);
        model.addAttribute("left", dir+"left");
        model.addAttribute("center", dir+"address");
        return "index";
    }

    @RequestMapping("/deladdr")
    public String deladdr(Model model, HttpSession httpSession, @RequestParam("id") Integer addrid) {
        try {
            System.out.println(addrid);
            addrService.del(addrid);
            address(model, httpSession);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return "index";
    }


    @RequestMapping("/addaddr")
    public String addaddr(Model model) {
        model.addAttribute("left", dir+"left");
        model.addAttribute("center", dir+"addaddr");

        return "index";
    }

    @RequestMapping("/addaddrimpl")
    public  String addaddrimpl(Model model, AddrDto addrDto, HttpSession httpSession) {
        try {
            addrDto.setCustId(httpSession.getAttribute("id").toString());
            System.out.println(addrDto);
            addrService.add(addrDto);
            address(model, httpSession);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return "index";
    }
}
