package com.fox.IPGot;

import com.google.gson.Gson;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.lang3.StringUtils;

public class IPGot {

    private static Gson gson = new Gson();

    public static IPGotDTO getIP(String ip) {
        try {
            if (isValid(ip)) {
                HttpClient httpClient = new HttpClient();
                PostMethod postMethod = new PostMethod("https://iplocation.com/");
                postMethod.setParameter("ip", ip);
                int status = httpClient.executeMethod(postMethod);
                if (status == 200) {
                    byte[] bytes = postMethod.getResponseBody();
                    String jsonData = new String(bytes);
                    return gson.fromJson(jsonData, IPGotDTO.class);
                }
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return null;
    }

    private static boolean isValid(String ip) {
        return (ip != null && StringUtils.countMatches(ip, ".") == 3);
    }
}
