package com.hana.controller;

import com.hana.app.data.dto.CustDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class AjaxImplController {
    @RequestMapping("/getservertime")
    public Object getservertime() {
        Date date = new Date();
        return date;
    }
    @RequestMapping("/getdata")
    public Object getdata() {
        List<CustDto> list = new ArrayList<>();
        list.add(new CustDto("id","pwd","james"));
        list.add(new CustDto("id","pwd","james"));
        list.add(new CustDto("id","pwd","james"));
        list.add(new CustDto("id","pwd","james"));
        list.add(new CustDto("id","pwd","james"));
        return list;
    }
    @RequestMapping("/checkid")
    public Object checkid(@RequestParam("id") String id) {
        String result = "1";
        if(id.equals("qqq")) {
            result="0";
        }
        return result;
    }
    @RequestMapping("/ranking")
    public Object ranking(Model model) {
        List<String> list = new ArrayList<>();
        list.add("김하영");
        list.add("김주혜");
        list.add("김서윤");
        list.add("임탁균");
        list.add("한원희");
        Collections.shuffle(list);
        model.addAttribute("rankings", list);
        return list;
    }
}
