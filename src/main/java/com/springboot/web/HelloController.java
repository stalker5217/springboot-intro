package com.springboot.web;

import com.springboot.web.dto.HelloResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @RestController
 * Controller를 JSON을 반환하는 컨트롤러를 만들어 줌.
 */
@RestController
public class HelloController {
    // HTTP GET 방식 Mapper
    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }

    @GetMapping("/hello/dto")
    public HelloResponseDto helloDto(@RequestParam("name") String name,
                                     @RequestParam("amount") int amount)
    {
        return new HelloResponseDto(name, amount);
    }
}

