package com.codephety.controller;

import com.codephety.marsrover.MarsroverApplication;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@RunWith(SpringRunner.class)
@ContextConfiguration(classes= MarsroverApplication.class)
@WebMvcTest(MarsRoverController.class)
public class MarsRoverControllerTest {

    @Autowired
    private MockMvc mockMvc;


    @Test
    public void shouldReturn404() throws Exception {
        this.mockMvc.perform(get("/")).andDo(print()).andExpect(status().isNotFound());
    }

    @Test
    public void shouldReturn200() throws Exception {
        this.mockMvc.perform(get("/v1/marsrover")).andDo(print()).andExpect(status().isOk());
    }

}
