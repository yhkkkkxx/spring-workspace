package com.hana.ncp;

import com.hana.util.OCRUtil;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.json.simple.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;

@SpringBootTest
@Slf4j
public class OcrTests {
    @Value("${app.dir.uploadimgdir}")
    String dir;
    @Test
    void contextLoads() {

        log.info("------------------------"+dir);
        String imgname = "biz.jpg";
        JSONObject jsonObject = (JSONObject) OCRUtil.getResult(dir, imgname);
        log.info(jsonObject.toJSONString());
        Map<String, String> map = OCRUtil.getData(jsonObject);
        map.values().forEach(txt -> {log.info(txt);});

        String img2name = "card3.jpg";
        jsonObject = (JSONObject) OCRUtil.getResult(dir, img2name);
        log.info(jsonObject.toJSONString());
        map = OCRUtil.getCardData(jsonObject);
        map.values().forEach(txt -> {log.info(txt);});
    }
}
