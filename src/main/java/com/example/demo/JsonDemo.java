package com.example.demo;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.Map;

public class JsonDemo {

    private static ObjectMapper objectMapper = new ObjectMapper();

    public static void main(String[] args) throws IOException {
        String json = "{ \"color\" : \"Black\"}";
        Map<String, String> map = objectMapper
                .readValue(json, new TypeReference<Map<String,String>>(){});
        System.out.println(map.get("color"));
    }
}
