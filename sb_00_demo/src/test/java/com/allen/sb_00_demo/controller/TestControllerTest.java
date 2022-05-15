package com.allen.sb_00_demo.controller;

import com.allen.sb_00_demo.bean.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class TestControllerTest {

    @Test
    void save() {
    }

    @Test
    void delete() {
    }

    @Test
    void warn() {
    }

    @Test
    void getParam() {
    }

    @Test
    void getUser(@Autowired MockMvc mvc) throws Exception {
        User user = User.of("allen", 18, "male");
        ObjectMapper objectMapper = new ObjectMapper();
        String userJson = objectMapper.writeValueAsString(user);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/rest/post/user")
                .content(userJson)
                .contentType(MediaType.APPLICATION_JSON);

        ResultActions actions = mvc.perform(requestBuilder);

        MvcResult mvcResult = actions.andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();

        int status = mvcResult.getResponse().getStatus();
        System.out.println(status);
    }
}