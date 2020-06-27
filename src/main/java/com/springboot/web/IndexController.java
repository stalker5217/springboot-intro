package com.springboot.web;

import com.springboot.config.auth.LoginUser;
import com.springboot.config.auth.dto.SessionUser;
import com.springboot.service.posts.PostsService;

import com.springboot.web.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Controller
public class IndexController {
    private final PostsService postsService;
    private final HttpSession httpSession;

    /**
     * Mustache-starter 의존성 주입으로
     * '/resources/templates/index.mustache'가 반환 된다.
     *
     * @param model : Server Template engine에서 사용할 수 있는 객체를 저장할 수 있다.
     *              index.mustache로 쿼리 결과가 전달된다.
     */
    @GetMapping("/")
    public String index(Model model, @LoginUser SessionUser user){
        model.addAttribute("posts", postsService.findAllDesc());

        if(user != null){
            model.addAttribute("login_name", user.getName());
        }

        return "index";
    }

    @GetMapping("/posts/save")
    public String postsSave(){
        return "posts-save";
    }

    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model){
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post", dto);

        return "posts-update";
    }
}
