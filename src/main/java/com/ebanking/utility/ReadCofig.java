package com.ebanking.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ReadCofig {
    Properties properties;
    public ReadCofig() {
        File src = new File("/Users/sonalibankar/Desktop/powerCalculator/eBankingProject/Configuration/config.properties");
        try {
            FileInputStream fs = new FileInputStream(src);
            properties = new Properties();
            properties.load(fs);
        } catch (Exception e) {
            System.out.println("Exception :"+e.getMessage());
        }
    }
    public String getBaseUrl(){

        String baseURL = properties.getProperty("baseURL");
        return baseURL;
    }
    public String getUserName(){
        String userName = properties.getProperty("userName");
        return userName;
    }
    public String getPassword(){
        String password = properties.getProperty("password");
        return password;
    }
    public String getChromePath(){
        String chromePath = properties.getProperty("chromePath");
        return chromePath;
    }
    public String getGeckoPath(){
        String geckoPath = properties.getProperty("geckoPath");
        return geckoPath;
    }
    public String getJsonPath(){
        String jsonPath = properties.getProperty("jsonPath");
        return jsonPath;
    }
}
