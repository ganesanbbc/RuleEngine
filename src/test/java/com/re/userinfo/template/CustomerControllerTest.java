package com.re.userinfo.template;

import com.re.UserInfoApplication;
import com.re.controller.UserInfoController;
import com.re.userinfo.service.UserInfoService;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;

import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = UserInfoApplication.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CustomerControllerTest {


    public static final String SOME_NAME = "SOME_NAME";

    private MockMvc mockMVC;

    @Mock
    private UserInfoService personService;

    @Autowired
    private WebApplicationContext wac;

    @InjectMocks
    private UserInfoController controller;

    @Before
    public void setup() {
        this.mockMVC = MockMvcBuilders.standaloneSetup(controller).build();
    }


    @Test
    public void shouldGetCustomers() throws Exception {
        mockMVC.perform(get("/")).andExpect(status().isOk())
                .andExpect(view().name("index"));
    }

    @Test
    public void shouldGetAddCustomerPage() throws Exception {
        mockMVC.perform(get("/createUser")).andExpect(status().isOk())
                .andExpect(view().name("addCustomer"));
    }

    @Test
    public void shouldGetAddCustomerServicePage() throws Exception {
        mockMVC.perform(post("/createUser")).andExpect(status().isOk())
                .andExpect(view().name("addService"));
    }

}