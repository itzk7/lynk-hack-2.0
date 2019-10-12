package com.guru.sishyan.service;

import com.byteowls.jopencage.JOpenCageGeocoder;
import com.byteowls.jopencage.model.JOpenCageForwardRequest;
import com.byteowls.jopencage.model.JOpenCageLatLng;
import com.byteowls.jopencage.model.JOpenCageResponse;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLConnection;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;
import javax.xml.xpath.XPathConstants;

;
import org.apache.tomcat.util.json.JSONParser;
import org.json.JSONObject;
import org.springframework.scheduling.annotation.Scheduled;
import org.w3c.dom.Document;


public class GeoService {
    public String ApiKey = "AIzaSyDxsVVjI1mK34sdykXhC5n2d3qH2tBuc6Q";
    private static final String URL = "http://maps.googleapis.com/maps/api/geocode/json";

//    @Scheduled(fixedDelay = 5000)
//    public String[] getLatLongPositions(String address) throws Exception
//    {
//        address = "Kodambakkam";
//        int responseCode = 0;
////        String api = "https://maps.googleapis.com/maps/api/geocode/json?address=" + URLEncoder.encode(address, "UTF-8") +"&key="+ApiKey;
//        String api = "http://nominatim.openstreetmap.org/search.php?q="+address + "&format=json";
//        URL url = new URL(api);
//        HttpURLConnection httpConnection = (HttpURLConnection)url.openConnection();
//        httpConnection.connect();
//        responseCode = httpConnection.getResponseCode();
//        if(responseCode == 200)
//        {
//            InputStream inputStream = httpConnection.getInputStream();
//            BufferedReader bR = new BufferedReader(  new InputStreamReader(inputStream));
//            String line = "";
//
//            StringBuilder responseStrBuilder = new StringBuilder();
//            while((line =  bR.readLine()) != null){
//
//                responseStrBuilder.append(line);
//            }
//            inputStream.close();
//            JSONObject result= new JSONObject(responseStrBuilder.toString());
//            System.out.println(result.toString());
//
//        }
//        System.out.println("we failed Mr stark " + responseCode);
//        return null;
//    }
    public Double[] getLatLong(String address) {
        JOpenCageGeocoder jOpenCageGeocoder = new JOpenCageGeocoder("3baf54955c69497c82ad11ec9f6caa0b");
        JOpenCageForwardRequest request = new JOpenCageForwardRequest(address);

        JOpenCageResponse response = jOpenCageGeocoder.forward(request);
        JOpenCageLatLng firstResultLatLng = response.getFirstPosition(); // get the coordinate pair of the first result
        System.out.println(firstResultLatLng.getLat() + " " + firstResultLatLng.getLng());
        return new Double[] {firstResultLatLng.getLat(), firstResultLatLng.getLng()};
    }
}

