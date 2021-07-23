package com.medium.demo.conrollers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.medium.demo.entities.Employee;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@ActiveProfiles("test")
@AutoConfigureMockMvc
class EmployeeControllerIntegrationTest {


    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper objectMapper;
    @Test
    void getEmployees() throws Exception {
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/employee")).andExpect(MockMvcResultMatchers.status().is(200)).andReturn();
        Employee[] employees = objectMapper.readValue(mvcResult.getResponse().getContentAsString(), Employee[].class);
        Assertions.assertEquals("test",employees[0].getEmail());
    }
}