package com.hana.controller;

import com.github.pagehelper.PageInfo;
import com.hana.app.data.dto.CustDto;
import com.hana.app.service.CustService;
import com.hana.util.StringEnc;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
            list.stream().forEach(c->{c.setName(StringEnc.decryptor(c.getName()));});
            model.addAttribute("custs", list);
            model.addAttribute("target", "/cust");
            model.addAttribute("left", dir+"left");
            model.addAttribute("center", dir+"get");

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return "index";
    }
    @RequestMapping("/allpage")
    public String allpage(@RequestParam(value = "pageNo", defaultValue = "1") int pageNo, Model model) throws Exception {
        PageInfo<CustDto> p;
        try {
            p = new PageInfo<>(custService.getPage(pageNo), 5); // 5:하단 네비게이션 개수
            model.addAttribute("cpage",p);
            model.addAttribute("left",dir+"left");
            model.addAttribute("center",dir+"allpage");
        } catch (Exception e) {
            throw new Exception("시스템 장애: ER0001");
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
