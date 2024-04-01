package com.hana.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/chart")
public class ChartController {
    String dir = "chart/";
    @RequestMapping("/")
    public String main(Model model) {
        model.addAttribute("left", dir+"left");
        model.addAttribute("center", dir+"center");
        return "index";
    }
    @RequestMapping("/chart1")
    public String html1(Model model) {
        model.addAttribute("left", dir+"left");
        model.addAttribute("center", dir+"chart1");
        return "index";
    }
    @RequestMapping("/chart2")
    public String htl2(Model model) {
        model.addAttribute("left", dir+"left");
        model.addAttribute("center", dir+"chart2");
        return "index";
    }
    @RequestMapping("/chart3")
    public String html3(Model model) {
        model.addAttribute("left", dir+"left");
        model.addAttribute("center", dir+"chart3");
        return "index";
    }
    @RequestMapping("/chart4")
    public String html4(Model model) {
        model.addAttribute("left", dir+"left");
        model.addAttribute("center", dir+"chart4");
        return "index";
    }
    @RequestMapping("/chart5")
    public String html5(Model model) {
        model.addAttribute("left", dir+"left");
        model.addAttribute("center", dir+"chart5");
        return "index";
    }

}
