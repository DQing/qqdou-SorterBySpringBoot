package com.example.demo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

public class PersonControllerTest {
    private MockMvc mockMvc;

    @BeforeEach
    void init() {
        mockMvc = standaloneSetup(PersonController.class).build();
    }

    @Test
    void get_people() throws Exception{
        List<String> list = Arrays.asList("huang lizheng","dou qingqing");
        MultiValueMap<String, String> multiValueMap = new LinkedMultiValueMap<>();
        multiValueMap.addAll("names", list);
        mockMvc.perform(get("/people")
                .params(multiValueMap))
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].name").value("DOU,QINGQING"))
                .andExpect(jsonPath("$[1].id").value(2))
                .andExpect(jsonPath("$[1].name").value("HUANG,LIZHENG"))
                .andExpect(status().isOk());
    }

    @Test
    void should_return_400() throws Exception {
        List<String> list = Collections.emptyList();
        MultiValueMap<String, String> multiValueMap = new LinkedMultiValueMap<>();
        multiValueMap.addAll("names", list);
        mockMvc.perform(get("/people")
                .params(multiValueMap))
                .andExpect(status().is(400));
    }
    @Test
    void should_also_return_400() throws Exception {
        List<String> list = Arrays.asList("huang lizheng", "douqingqing");
        MultiValueMap<String, String> multiValueMap = new LinkedMultiValueMap<>();
        multiValueMap.addAll("names", list);
        mockMvc.perform(get("/people")
                .params(multiValueMap))
                .andExpect(status().is(400));
    }
}
