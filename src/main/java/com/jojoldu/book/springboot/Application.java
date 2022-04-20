package com.jojoldu.book.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication //스프링 부트 자동설정, 스프링 Bean읽기, 생성, 이 위치부터 설정을 읽으므로 최상단 위치
public class Application { //메인 클래스로 사용
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args); //내장 was실행
        //스프링 부트에서 내장 was 권장 -> 어디서나 같은 환경에서 스프링 부트 배포 가능하기 때문
    }
}
