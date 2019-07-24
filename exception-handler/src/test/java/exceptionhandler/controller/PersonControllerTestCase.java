package exceptionhandler.controller;


import org.adendrata.spring.tutorial.exceptionhandler.Application;
import org.adendrata.spring.tutorial.exceptionhandler.controller.PersonController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import static org.hamcrest.CoreMatchers.is;

@RunWith(SpringRunner.class)
@WebMvcTest(PersonController.class)
@ContextConfiguration(classes = {Application.class})
public class PersonControllerTestCase {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void postPerson() throws Exception {

        MockHttpServletRequestBuilder requestBuilders = MockMvcRequestBuilders
                .post("/api/v1/person")
                .contextPath("/api/v1")
                .servletPath("/person")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{ \"firstName\": \"aden\", \"height\": 1, \"lastName\": \"drata\" }");

        mockMvc.perform(requestBuilders)
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(jsonPath("$.firstName", is("aden")))
                .andExpect(jsonPath("$.lastName", is("drata")))
                .andExpect(jsonPath("$.height", is(1)));
    }

    @Test
    public void postPerson_butFirstNameNull() throws Exception {

        MockHttpServletRequestBuilder requestBuilders = MockMvcRequestBuilders
                .post("/api/v1/person")
                .contextPath("/api/v1")
                .servletPath("/person")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{ \"height\": 1, \"lastName\": \"drata\" }");

        mockMvc.perform(requestBuilders)
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().is(400))
                .andExpect(jsonPath("$.result", is("FAILURE")));
    }


    @Test
    public void postPerson_butHeightNull() throws Exception {

        MockHttpServletRequestBuilder requestBuilders = MockMvcRequestBuilders
                .post("/api/v1/person")
                .contextPath("/api/v1")
                .servletPath("/person")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{ \"firstName\": \"aden\", \"lastName\": \"drata\" }");

        mockMvc.perform(requestBuilders)
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().is(400))
                .andExpect(jsonPath("$.result", is("FAILURE")));
    }

}
