package com.springboot.junit.controller;

import com.springboot.junit.pojo.User;
import com.springboot.junit.service.UserService;
import net.sf.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

/**
 * @projectName springboot_junit
 * @Description TODO
 * @Author liuchj
 * @Date 2019/08/22 10:49
 * @Version 1.0
 **/

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    UserService userService;

    @Test
    public void getUser()throws Exception {

        User user = new User(12,"tom",18,1);
        JSONObject expectResult = JSONObject.fromObject(user);

        Mockito.when(userService.getOne()).thenReturn(user);
        RequestBuilder requestBuilder= MockMvcRequestBuilders.get("http://127.0.0.1:8080/getUser");
        MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();
        String actualResult = mvcResult.getResponse().getContentAsString();
        JSONAssert.assertEquals(expectResult.toString(), actualResult,true);
    }


}