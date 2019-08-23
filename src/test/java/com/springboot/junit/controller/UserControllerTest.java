package com.springboot.junit.controller;

import com.springboot.junit.JunitApplication;
import com.springboot.junit.pojo.User;
import com.springboot.junit.service.UserService;
import net.sf.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.net.URL;

/**
 * @projectName springboot_junit
 * @Description TODO
 * @Author liuchj
 * @Date 2019/08/22 10:49
 * @Version 1.0
 **/

@RunWith(SpringRunner.class)
@SpringBootTest(classes = JunitApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    UserService userService;

    /**
     * @LocalServerPort 提供了 @Value("${local.server.port}") 的代替
     */
    @LocalServerPort
    private int port;

    private URL base;

    @Autowired
    private TestRestTemplate restTemplate;

    @Before
    public void setUp() throws Exception {
        //生成随机端口号
        String url = String.format("http://localhost:%d/", port);
        System.out.println(String.format("port is : [%d]", port));
        this.base = new URL(url);
    }


    @Test
    public void getUser()throws Exception {

        User user = new User(12,"tom",18,1);
        JSONObject expectResult = JSONObject.fromObject(user);
        Mockito.when(userService.getOne()).thenReturn(user);
        RequestBuilder requestBuilder= MockMvcRequestBuilders.get(this.base.toString() +"/getUser");
        MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();
        String actualResult = mvcResult.getResponse().getContentAsString();
        System.out.println("actualResult = " + actualResult);
        JSONAssert.assertEquals(expectResult.toString(), actualResult,true);
    }

    @Test
    public void testRestTemplate() {

        ResponseEntity<String> response = this.restTemplate.getForEntity(
                this.base.toString() + "/getUser", String.class, "");
        System.out.println(String.format("测试结果为：%s", response.getBody()));
    }


}