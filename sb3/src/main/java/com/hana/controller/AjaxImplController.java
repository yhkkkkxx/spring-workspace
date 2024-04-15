package com.hana.controller;

import com.hana.app.data.dto.Chart2Dto;
import com.hana.app.data.dto.Chart3Dto;
import com.hana.app.data.dto.CustDto;
import com.hana.app.data.dto.ShopDto;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@Slf4j
public class AjaxImplController {
    private String aa;
    public AjaxImplController() {
        log.info("start-----------");
        aa = "aaaa";
    }
    @RequestMapping("/getservertime")
    public Object getservertime() {
        Date date = new Date();
        log.info(this.aa+"----------");
        return date;
    }
    @RequestMapping("/getdata")
    public Object getdata() {
        List<CustDto> list = new ArrayList<>();
        list.add(new CustDto("id01","pwd","james"));
        list.add(new CustDto("id02","pwd","james"));
        list.add(new CustDto("id03","pwd","james"));
        list.add(new CustDto("id04","pwd","james"));
        list.add(new CustDto("id05","pwd","james"));
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

    @RequestMapping("/chart2")
    public Object chart2() {
        List<Chart2Dto> list = new ArrayList<>();
        list.add(new Chart2Dto("S001", 10, 20, 30, 20, 10, 15));
        list.add(new Chart2Dto("S002", 13, 30, 60, 10, 10, 25));
        list.add(new Chart2Dto("S003", 11, 10, 70, 80, 15, 35));
        list.add(new Chart2Dto("S004", 18, 20, 20, 90, 22, 45));
        JSONArray ja = new JSONArray();


        list.stream().forEach(c -> {
            JSONObject jo = new JSONObject();
            // [{name, data:[]}]
            jo.put("name", c.getName());
            jo.put("data", c.getM());
            ja.add(jo);
        });
//        for(Chart2Dto c:list) {
//            JSONObject jo = new JSONObject();
//            // [{name, data:[]}]
//            jo.put("name", c.getName());
//            jo.put("data", c.getM());
//            ja.add(jo);
//        }
        return ja;
    }
    @RequestMapping("/chart3")
    public Object chart3() {
        List<Chart3Dto> list = new ArrayList<>();
        list.add(new Chart3Dto("S001", 10, 20, 30, 20, 10, 15, 25, 32, 19, 5));
        list.add(new Chart3Dto("S002", 13, 30, 60, 10, 10, 25, 36, 14, 35, 24));
        list.add(new Chart3Dto("S003", 11, 10, 70, 80, 15, 35, 62, 15, 56, 72));
        list.add(new Chart3Dto("S004", 18, 20, 20, 90, 22, 45, 62, 52, 37, 50));

        JSONArray ja = new JSONArray();
        for(Chart3Dto c:list) {
            JSONObject jo = new JSONObject();
            // [{name, data:[]}]
            jo.put("name", c.getName());
            jo.put("data", c.getM());
            ja.add(jo);
        }
        return ja;
    }
    @RequestMapping("/chart4")
    public Object chart4(@RequestParam("gender") String gender){
        JSONArray ja = new JSONArray();

        List<Chart2Dto> list = new ArrayList<>();
        // [{"name":"S001","m1":10,....},{},{},{}]
        list.add(new Chart2Dto("f",30,10,10,10,20,20));
        list.add(new Chart2Dto("m",40,10,10,10,10,20));

        list.stream().filter(c-> c.getName().equals(gender)).forEach(c->{
            c.getM().stream().forEach(n->{
                JSONArray ja2 = new JSONArray();
                // [["",20],[],[],[]]
                ja2.add("OTT");
                ja2.add(n);
                ja.add(ja2);
            });
        });
        //{"data:":[], "title":"f"}
        JSONObject jo = new JSONObject();
        jo.put("data",ja);
        jo.put("title",gender);
        return jo;
    }

}
