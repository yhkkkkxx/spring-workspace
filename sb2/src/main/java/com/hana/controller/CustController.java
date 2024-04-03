package com.hana.controller;

import com.hana.app.data.dto.CustDto;
import com.hana.app.service.CustService;
import lombok.RequiredArgsConstructor;
import org.eclipse.tags.shaded.org.apache.xpath.operations.Mod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
        model.addAttribute("left", dir+"left");
        model.addAttribute("center", dir+"add");
        return "index";
    }

    @RequestMapping("/addimpl")
    public String addimpl(Model model, CustDto custDto) {
        try {
            custService.add(custDto);
            detail(model, custDto.getId());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return "index";
        //return "redirect:/cust/detail?id="+custDto.getId();
    }
    @RequestMapping("/get")
    public String get(Model model) {
        List<CustDto> list = null;
        try {
            list = custService.get();
            model.addAttribute("custs", list);
            model.addAttribute("left", dir+"left");
            model.addAttribute("center", dir+"get");

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return "index";
    }
    @RequestMapping("/detail")
    public String detail(Model model, @RequestParam("id") String id){
        CustDto custDto = null;
        try {
            custDto = custService.get(id);
            model.addAttribute("custs", custDto);
            model.addAttribute("left", dir+"left");
            model.addAttribute("center",dir+"detail");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return "index";
    }

}
