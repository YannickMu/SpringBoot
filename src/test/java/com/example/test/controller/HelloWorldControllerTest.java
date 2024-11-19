package com.example.test.controller;

import com.example.test.helloworld.HelloWorldController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = HelloWorldController.class)
@AutoConfigureMockMvc(addFilters = false)
public class HelloWorldControllerTest {
    @Autowired
    private MockMvc mvc;

    @MockBean
    private HelloWorldController controller;

    @Test
    public void getHelloWorld() throws Exception {
        mvc.perform(get(HelloWorldController.PATH)).andExpect(status().isOk());
    }
}
