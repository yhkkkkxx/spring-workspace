package com.hana.util;


import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Slf4j
public class OCRUtil {
    public static JSONObject getResult(String imgpath, String imgname){
        JSONObject obj = null;

        String apiURL = "https://gojlwur9ps.apigw.ntruss.com/custom/v1/30126/fa8fd9435db59f6f8fde62cfed39b4305b7dbae7dec6b2c634e559caf1983f66/infer";
        String secretKey = "TnNmZ1FhaG9WZHVCZ3BDbld1UW9QeGJnVGZTSU5ITGY=";
        String imageFile = imgpath+imgname;

        try {
            URL url = new URL(apiURL);
            HttpURLConnection con = (HttpURLConnection)url.openConnection();
            con.setUseCaches(false);
            con.setDoInput(true);
            con.setDoOutput(true);
            con.setReadTimeout(30000);
            con.setRequestMethod("POST");
            String boundary = "----" + UUID.randomUUID().toString().replaceAll("-", "");
            con.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + boundary);
            con.setRequestProperty("X-OCR-SECRET", secretKey);

            JSONObject json = new JSONObject();
            json.put("version", "V2");
            json.put("requestId", UUID.randomUUID().toString());
            json.put("timestamp", System.currentTimeMillis());
            JSONObject image = new JSONObject();
            image.put("format", "jpg");
            image.put("name", "demo");
            JSONArray images = new JSONArray();
            images.add(image);
            json.put("images", images);
            String postParams = json.toString();

            con.connect();
            DataOutputStream wr = new DataOutputStream(con.getOutputStream());
            long start = System.currentTimeMillis();
            File file = new File(imageFile);
            writeMultiPart(wr, postParams, file, boundary);
            wr.close();

            int responseCode = con.getResponseCode();
            BufferedReader br;
            if (responseCode == 200) {
                br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            } else {
                br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
            }
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = br.readLine()) != null) {
                response.append(inputLine);
            }
            br.close();
            JSONParser parser = new JSONParser();
            obj = (JSONObject) parser.parse(response.toString());
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        }

        return obj;
    }

    private static void writeMultiPart(OutputStream out, String jsonMessage, File file, String boundary) throws
            IOException {
        StringBuilder sb = new StringBuilder();
        sb.append("--").append(boundary).append("\r\n");
        sb.append("Content-Disposition:form-data; name=\"message\"\r\n\r\n");
        sb.append(jsonMessage);
        sb.append("\r\n");

        out.write(sb.toString().getBytes("UTF-8"));
        out.flush();

        if (file != null && file.isFile()) {
            out.write(("--" + boundary + "\r\n").getBytes("UTF-8"));
            StringBuilder fileString = new StringBuilder();
            fileString
                    .append("Content-Disposition:form-data; name=\"file\"; filename=");
            fileString.append("\"" + file.getName() + "\"\r\n");
            fileString.append("Content-Type: application/octet-stream\r\n\r\n");
            out.write(fileString.toString().getBytes("UTF-8"));
            out.flush();

            try (FileInputStream fis = new FileInputStream(file)) {
                byte[] buffer = new byte[8192];
                int count;
                while ((count = fis.read(buffer)) != -1) {
                    out.write(buffer, 0, count);
                }
                out.write("\r\n".getBytes());
            }

            out.write(("--" + boundary + "--\r\n").getBytes("UTF-8"));
        }
        out.flush();
    }

    public static Map getCardData(JSONObject obj){
        Map<String,String> map = new HashMap<>();
        JSONArray images = (JSONArray) obj.get("images");
        JSONObject jo1 = (JSONObject) images.get(0);
        JSONArray fields = (JSONArray) jo1.get("fields");
        log.info(fields.toJSONString());

//        JSONObject biznum_obj = (JSONObject) fields.get(0);
//        String biznum = (String)biznum_obj.get("inferText");

//        JSONObject card_obj = (JSONObject) fields.get(0);
//        String card = (String)card_obj.get("inferText");

        JSONObject cardnum_obj = (JSONObject) fields.get(0);
        String cardnum = (String)cardnum_obj.get("inferText");

        JSONObject validthru_obj = (JSONObject) fields.get(1);
        String validthru = (String)validthru_obj.get("inferText");

        JSONObject name_obj = (JSONObject) fields.get(2);
        String name = (String)name_obj.get("inferText");

//        map.put("biznum", biznum);
//        map.put("card", card);
        map.put("cardnum", cardnum);
        map.put("validthru", validthru);
        map.put("name", name);

        return map;
    }

    public static Map getData(JSONObject obj){
        Map<String,String> map = new HashMap<>();
        JSONArray images = (JSONArray) obj.get("images");
        log.info("--------------------------"+images.toString());
        JSONObject jo1 = (JSONObject) images.get(0);
        JSONArray fields = (JSONArray) jo1.get("fields");

//        JSONObject biznum_obj = (JSONObject) fields.get(0);
//        String biznum = (String)biznum_obj.get("inferText");

        JSONObject bizname_obj = (JSONObject) fields.get(0);
        String bizname = (String)bizname_obj.get("inferText");

        JSONObject bizowner_obj = (JSONObject) fields.get(1);
        String bizowner = (String)bizowner_obj.get("inferText");

        JSONObject bizdate_obj = (JSONObject) fields.get(2);
        String bizdate = (String)bizdate_obj.get("inferText");

        JSONObject bizadd_obj = (JSONObject) fields.get(3);
        String bizadd = (String)bizadd_obj.get("inferText");

//        map.put("biznum", biznum);
        map.put("bizname", bizname);
        map.put("bizowner", bizowner);
        map.put("bizdate", bizdate);
        map.put("bizadd", bizadd);

        return map;
    }


}