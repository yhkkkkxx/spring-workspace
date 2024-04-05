package com.hana.controller;

import com.hana.app.data.dto.CustDto;
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
    public String addimpl(Model model, CustDto custDto) {
        try {
            custService.add(custDto);
            //model.addAttribute("center", dir+"get");
            get(model);
            //return "redirect:/cust/detail?id="+custDto.getId();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return "index";
    }

    @RequestMapping("/get")
    public String get(Model model) {
        List<CustDto> list = null;
        try {
            list = custService.get();
            model.addAttribute("custs", list);
            model.addAttribute("center", dir+"get");

        } catch (Exception e) {
            throw new RuntimeException(e);
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
        System.out.println(custDto);
        CustDto c = CustDto.builder().id(custDto.getId()).pwd(custDto.getPwd()).name(custDto.getName()).build();
        System.out.println(c);
        try {
            custService.modify(custDto);
            get(model);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return "index";
    }

    @RequestMapping("/delete")
    public String delete(Model model, CustDto custDto) {
        try {
            custService.del(custDto.getId());
            get(model);
            //return "redirect:/cust/detiail?id="+custDto.getId()
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return "index";
    }

}
