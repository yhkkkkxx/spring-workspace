package com.hana.controller;

import com.hana.app.data.dto.CustDto;
import com.hana.app.data.dto.ShopDto;
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
    @RequestMapping("/geo/getdata")
    public Object geogetdata() {
        List<ShopDto> list = new ArrayList<>();
        list.add(new ShopDto(100,"순대국","a.jpg",37.5449352,127.0966045));
        list.add(new ShopDto(101,"파스타","b.jpg",37.5249352,127.0766045));
        list.add(new ShopDto(102,"햄버거","c.jpg",37.5849352,127.0166045));
        return list;
    }
    @RequestMapping("/geo/getshopdata")
    public Object geogetshopdata(@RequestParam("lat") double lat, @RequestParam("lng") double lng) {
        Random rand = new Random();
        List<ShopDto> list = new ArrayList<>();
        list.add(new ShopDto(100,"순대국","a.jpg",lat+rand.nextDouble(-0.06, 0.06),lng+rand.nextDouble(-0.07, 0.07)));
        list.add(new ShopDto(101,"파스타","b.jpg",lat+rand.nextDouble(-0.06, 0.06),lng+rand.nextDouble(-0.07, 0.07)));
        list.add(new ShopDto(102,"햄버거","c.jpg",lat+rand.nextDouble(-0.06, 0.06),lng+rand.nextDouble(-0.07, 0.07)));
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
