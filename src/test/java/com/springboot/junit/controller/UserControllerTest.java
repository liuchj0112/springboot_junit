package com.springboot.junit.controller;

import com.springboot.junit.pojo.User;
import com.springboot.junit.service.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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

    @MockBean
    UserService userService;

    @Test
    public void getUser()throws Exception {

        User user = new User(5,"abc",12,1);
        Mockito.when(userService.getOne(anyInt())).thenReturn(user);
        RequestBuilder requestBuilder= get("/getUser/"+8);
        String actualResult = mockMvc.perform(requestBuilder).andExpect(status().isOk())
                .andDo(print()).andReturn().getResponse().getContentAsString();
        String expectResult = "{\"id\":5,\"username\":\"abc\",\"age\":12,\"gender\":1}";
        Assert.assertEquals(expectResult, actualResult);
    }


}