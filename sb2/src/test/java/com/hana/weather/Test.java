package com.hana.weather;


import com.hana.util.WeatherUtil;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONObject;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.io.IOException;
import java.text.ParseException;

@SpringBootApplication
@EnableScheduling
@Slf4j
public class Test {

    @org.junit.jupiter.api.Test
    void contextLoads() throws IOException, ParseException, org.json.simple.parser.ParseException {
        String key = "zc1fFvuRYgybHd7Yii%2Bba9X14fURteyupYHB1toqylvjee1%2BKMCRVUvvuyQkDEVXAFD%2BDetR8yjmrss92C3siQ%3D%3D";
        String loc = "109";
        JSONObject jsonObject = (JSONObject) WeatherUtil.getWeather(loc, key);

        log.info("----------LOG----------------"+jsonObject.toJSONString());
    }

}
