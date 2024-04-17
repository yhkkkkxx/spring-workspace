package com.hana.ncp;


import com.hana.util.ChatBotUtil;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Base64;
import java.util.Date;

@SpringBootTest
@Slf4j
class ChatBotTests {

    private String secretKey = "Zm5mYXB0Z1dFS0lGcnFlWmlZeHlDd1hYZUxSS2ROWGw=";
    private String apiUrl = "https://xdpyx9zoyh.apigw.ntruss.com/custom/v1/14178/e65864fa2ec203f8f79f86fa4486a7eefc617fd166d246b426e09e63b637941d";


    @Test
    void contextLoads() throws Exception {
        String msg = "클라우드봇은 언제 만들어졌어";
        String result = ChatBotUtil.getMsg(apiUrl, secretKey, msg);
        log.info(result);
    }


}