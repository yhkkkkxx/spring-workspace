package com.hana.controller;

import com.hana.app.data.dto.CustDto;
import com.hana.app.data.entity.LoginCust;
import com.hana.app.repository.LoginCustRepository;
import com.hana.app.service.CustService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/cust")
@RequiredArgsConstructor
public class CustController {
    String dir = "cust/";
    final CustService custService;
    final LoginCustRepository loginCustRepository;

    @RequestMapping("/")
    public String main(Model model) {
        model.addAttribute("left", dir+"left");
        model.addAttribute("center", dir+"center");
        return "index";

    }
    @RequestMapping("/add")
    public String add(Model model) {
        System.out.println("add----------------");
        model.addAttribute("center", dir+"add");
        return "index";
    }
    @RequestMapping("/addimpl")
    public String addimpl(Model model, CustDto custDto) throws Exception {
        try {
            custService.add(custDto);
            return "redirect:/cust/detail?id="+custDto.getId();
        } catch (Exception e) {
            throw new Exception("ER0001");
        }

        //return "index";
    }

    @RequestMapping("/get")
    public String get(Model model) throws Exception {
        List<CustDto> list = null;
        try {
            list = custService.get();
            model.addAttribute("custs", list);
            model.addAttribute("center", dir+"get");

        } catch (Exception e) {
            throw new Exception("ER0001");
        }
        return "index";
    }
    @RequestMapping("/detail")
    public String custdetail(Model model, @RequestParam("id") String id) {
        List<CustDto> list = new ArrayList<>();
        CustDto custDto = null;
        try {
            custDto = custService.get(id);
            model.addAttribute("cust", custDto);
            model.addAttribute("left", dir+"left");
            model.addAttribute("center", dir+"detail");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return "index";
    }

    @RequestMapping("/update")
    public String update(Model model, CustDto custDto) {
        try {
            custService.modify(custDto);
            return "redirect:/cust/get";
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @RequestMapping("/delete")
    public String delete(Model model, @RequestParam("id") String id) throws Exception {
        System.out.println("delete "+ id);
        try {
            custService.del(id);
            return "redirect:/cust/get";
        } catch (Exception e) {
            throw new Exception("ER0001");
        }
    }


    @RequestMapping("/info")
    public String login(Model model) {

        long cnt = loginCustRepository.count();
        List<LoginCust> loginlist = new ArrayList<>();
        Iterable<LoginCust> list = loginCustRepository.findAll();

        list.forEach(loginCust -> {
            if(loginCust != null){
                loginlist.add(loginCust);
            }
        });
        model.addAttribute("cnt", loginlist.size());
        model.addAttribute("loginlist", loginlist);
        model.addAttribute("center", dir+"info");
        return "index";
    }

}
