package com.springboot.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 *  RunWith(SpringRunner.class)
 *  테스트를 진행할 때 JUnit에 내장된 실행자 외에 다른 실행자를 실행시킨다.
 *  즉, JUnit과 Springboot Test를 연결시켜준다.
 *
 *  WebMvcTest
 * @Controller, @ControllAcvice 사용 가능
 */

@RunWith(SpringRunner.class)
@WebMvcTest
public class HelloControllerTest {
    @Autowired // Bean 주입
    private MockMvc mvc; // 웹 API, HTTP GET, POST 등 테스트 가능

    @Test
    public void returnHello() throws Exception{
        String hello = "hello";

        /**
         * GET으로 /hello 호출
         * status check : 200
         * content check : "hello"
         */
        mvc.perform(get("/hello")).andExpect(status().isOk()).andExpect(content().string(hello));
    }

    @Test
    public void returnHelloDto() throws Exception{
        String name = "hello";
        int amount = 1000;

        /**
         * GET으로 /hello/dto 호출
         * param으로 parameter 설정 가능 (String만 허용)
         * jsonPath : $로 필드명 명시
         */
        mvc.perform(get("/hello/dto")
                .param("name", name)
                .param("amount", String.valueOf(amount)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(name)))
                .andExpect(jsonPath("$.amount", is(amount)));

    }
}
