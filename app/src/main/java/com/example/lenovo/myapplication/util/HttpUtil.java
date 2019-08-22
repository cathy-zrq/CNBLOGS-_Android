package com.example.lenovo.myapplication.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class HttpUtil {

    public static String sendHttpRequest(String address, String data){
        try {
            HttpURLConnection hc = (HttpURLConnection) new URL(address).openConnection();
            hc.setRequestMethod("POST");
            hc.getOutputStream().write(data.getBytes());
            hc.connect();
            return readStream(hc.getInputStream());
        }catch (IOException e){
            e.printStackTrace();
        }
        return "";
    }

    public static String GetResult(String address) throws IOException {
        URL url=new URL(address);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        Scanner scn=new Scanner(connection.getInputStream(),"UTF-8");
        String result=scn.useDelimiter("\\A").next();
        return  result;
    }

    public static String readStream(InputStream is){
        BufferedReader br = new BufferedReader(new InputStreamReader((is)));
        StringBuilder stringBuilder = new StringBuilder();
        String line = null;
        try {
            while ((line = br.readLine()) != null){
                stringBuilder.append(line);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }
}
