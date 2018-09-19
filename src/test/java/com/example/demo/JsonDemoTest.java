package com.example.demo;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.Null;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JsonDemoTest {
    private ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void should_test_string() throws IOException {
        String json = "{ \"color\" : \"Black\"}";
        Map<String, String> map = objectMapper
                .readValue(json, new TypeReference<Map<String,String>>(){});
        assertEquals("Black", map.get("color"));
        assertEquals(String.class, map.get("color").getClass());
    }
    @Test
    void should_test_short_number() throws IOException {
        String json = "{ \"age\" : 1}";
        Map<String, Short> map = objectMapper
                .readValue(json, new TypeReference<Map<String,Short>>(){});
        assertEquals(1, map.get("age").shortValue());
        assertEquals(Short.class, map.get("age").getClass());
    }
    @Test
    void should_test_integer_number() throws IOException {
        String json = "{ \"age\" : 1}";
        Map<String, Integer> map = objectMapper
                .readValue(json, new TypeReference<Map<String,Integer>>(){});
        assertEquals(1, map.get("age").shortValue());
        assertEquals(Integer.class, map.get("age").getClass());
    }
    @Test
    void should_test_float_number() throws IOException {
        String json = "{ \"age\" : 1}";
        Map<String, Float> map = objectMapper
                .readValue(json, new TypeReference<Map<String,Float>>(){});
        assertEquals(1, map.get("age").shortValue());
        assertEquals(Float.class, map.get("age").getClass());
    }
    @Test
    void should_test_list() throws IOException {
        String json = "[\"jee\",\"san\"]";
        List<String> list = objectMapper
                .readValue(json, new TypeReference<List<String>>(){});
        assertEquals("jee", list.get(0));
        assertEquals("san", list.get(1));
    }
    @Test
    void should_test_boolean() throws IOException {
        String json = "[true,false]";
        List<Boolean> list = objectMapper
                .readValue(json, new TypeReference<List<Boolean>>(){});
        assertEquals(true, list.get(0));
        assertEquals(false, list.get(1));
    }
    @Test
    void should_test_null() throws IOException {
        String json = "[null]";
        List<Null> list = objectMapper
                .readValue(json, new TypeReference<List<Null>>(){});
        assertEquals(null, list.get(0));
    }
}
