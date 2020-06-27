package com.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * Main Class
 * @SpringBootApplication annotation으로 인해
 * 스프링부트 자동 설정, Bean 읽기 생성 설정 등 자동화
 * 이곳에서 부터 설정을 읽어나가기에 프로젝트 최상단에 위치해야함
 */
@SpringBootApplication
public class Application {
    public static void main(String[] args){
        // 내장 WAS 실행
        SpringApplication.run(Application.class, args);
    }
}
