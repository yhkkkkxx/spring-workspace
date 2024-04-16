package com.hana.ncp;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import com.hana.util.NcpUtil;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
class SentimentTests {
    @Value("${app.key.ncp-id}")
    String ncpId;
    @Value("${app.key.ncp-secret}")
    String ncpSecret;

    @Test
    void contextLoads() {
        String text = "오늘은 참 비도 오고 거시기 하네";
        JSONObject obj = (JSONObject) NcpUtil.getSentiment(ncpId, ncpSecret, text);
        log.info(obj.toJSONString());
//
//        String clientId = "nmfbdo5jys";//애플리케이션 클라이언트 아이디값";
//        String clientSecret = "C4qa83u34aMKeZbVsNt3mmdZxcfJGYeT0b2uO99U";//애플리케이션 클라이언트 시크릿값";
//
//        try {
////            String text = URLEncoder.encode("싸늘하다. 가슴에 비수가 날아와 꽂힌다.", "UTF-8");
//            String text = "싸늘하다. 가슴에 비수가 날아와 꽂힌다.";
//
//            String apiURL = "https://naveropenapi.apigw.ntruss.com/sentiment-analysis/v1/analyze"; //
//            URL url = new URL(apiURL);
//            HttpURLConnection con = (HttpURLConnection)url.openConnection();
//            con.setRequestMethod("POST");
//            con.setRequestProperty("Content-Type", "application/json;UTF-8");
//            con.setRequestProperty("X-NCP-APIGW-API-KEY-ID", clientId);
//            con.setRequestProperty("X-NCP-APIGW-API-KEY", clientSecret);
//            // post request
//            //  String postParams = "content=" + text;
//            con.setDoOutput(true);
//            JSONObject jsonObject = new JSONObject();
//            jsonObject.put("content",text);
//
//
//            DataOutputStream wr = new DataOutputStream(con.getOutputStream());
//            wr.write(jsonObject.toString().getBytes("UTF-8"));
//            wr.flush();
//            wr.close();
//            int responseCode = con.getResponseCode();
//            BufferedReader br;
//            if(responseCode==200) { // 정상 호출
//                br = new BufferedReader(new InputStreamReader(con.getInputStream()));
//            } else {  // 오류 발생
//                br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
//            }
//            String inputLine;
//            StringBuffer response = new StringBuffer();
//            while ((inputLine = br.readLine()) != null) {
//                response.append(inputLine);
//            }
//            br.close();
//            System.out.println(response.toString());
//
//            JSONParser jsonParser = new JSONParser();
//            JSONObject jo = new JSONObject();
//            jo = (JSONObject) jsonParser.parse(response.toString());
//        } catch (Exception e) {
//            System.out.println(e);
//        }

    }

}
