package com.hana.controller;

import com.hana.app.data.dto.ItemDto;
import com.hana.app.service.ItemService;
import com.hana.util.FileUploadUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/item")
@RequiredArgsConstructor
@Slf4j
public class ItemController {
    private final ItemService itemService;

    String dir = "item/";

    @Value("${app.dir.uploadimgdir}")
    String imgdir;

    @RequestMapping("/add")
    public String add(Model model) throws Exception {
        model.addAttribute("center",dir+"add");
        return "index";
    }
    @RequestMapping("/addimpl")
    public String addimpl(Model model, ItemDto itemDto) throws Exception {
        // 데이터 입력
        itemDto.setImgName(itemDto.getImage().getOriginalFilename());
        itemService.add(itemDto);

        log.info("------------------------"+imgdir);
        return "redirect:/item/get";
    }
    @RequestMapping("/updateimpl")
    public String updateimpl(ItemDto itemDto) throws Exception {
        // id, name, price, imgname or new img

        System.out.println(itemDto.getImgName());
        if(itemDto.getImage().isEmpty()) {
            itemService.modify(itemDto);
            FileUploadUtil.saveFile(itemDto.getImage(), imgdir);
        } else {
            String oldimg = itemDto.getImgName();
            itemDto.setImgName(itemDto.getImage().getOriginalFilename());
            itemService.modify(itemDto);

            FileUploadUtil.saveFile(itemDto.getImage(), imgdir);
            FileUploadUtil.deleteFile(oldimg, imgdir);
        }

        return "redirect:/item/get";
    }
    @RequestMapping("/delete")
    public String delete(Model model, ItemDto itemDto) throws Exception {
        // id, name, price, imgname or new img
        itemService.del(itemDto.getItemId());
        FileUploadUtil.deleteFile(itemDto.getImgName(), imgdir);


        return "redirect:/item/get";
    }
    @RequestMapping("/get")
    public String get(Model model) throws Exception {
        List<ItemDto> list = new ArrayList<>();
        try {
            list = itemService.get();
            model.addAttribute("itemlist", list);
            model.addAttribute("center", dir+"get");
            return "index";
        } catch (Exception e) {
            throw new Exception("EI0001");
        }
    }
    @RequestMapping("/detail")
    public String detail(Model model, @RequestParam("id") int id) throws Exception {
        ItemDto itemDto = null;
        try {
            itemDto = itemService.get(id);
            model.addAttribute("item", itemDto);
            model.addAttribute("center", dir+"detail");
        } catch (Exception e) {
            throw new Exception("EI0001");
        }
        return "index";
    }
}
