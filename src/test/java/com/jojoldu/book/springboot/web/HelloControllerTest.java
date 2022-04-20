package com.jojoldu.book.springboot.web;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = HelloController.class)
public class HelloControllerTest {

    @Autowired
    private MockMvc mvc; //웹 API를 테스트할 때 사용한다. HTTP GET,POST 등에 대한 API테스트 가능

    @Test
    public void hello가_리턴된다() throws Exception {
        String hello = "hello";

        mvc.perform(get("/hello")) //MockMvc로 /hello에 GET요청을 한다.
                .andExpect(status().isOk()) // 응답코드 200인지 검증
            .andExpect(content().string(hello)); //응답 본문 내용 검증
    }

    @Test
    public void helloDto가_리턴된다() throws Exception {
        String name = "hello";
        int amount = 1000;

        mvc.perform(get("/hello/dto") //get요청을 해당 url에 보냄
                        .param("name", name) //요청에 붙일 파라미터 설정
                        .param("amount", String.valueOf(amount))) //param메서드는 문자열만 가능
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(name))) //jsonPath는 DTO객체를 필드별로 검증하는 메서드
                .andExpect(jsonPath("$.amount", is(amount)));//$를 기준으로 필드명을 명시한다.
    }
}