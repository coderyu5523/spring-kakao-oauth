package org.example.loginapp.user;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@RequiredArgsConstructor
@Controller
public class UserController {
    private final UserService userService;
    private final HttpSession session;

    @GetMapping("/oauth/naver/callback")
    public String naverCallback(String code) {
        System.out.println("콜백 완료 : " + code);
        User sessionUser = userService.네이버로그인(code);
        session.setAttribute("sessionUser", sessionUser);
        return "redirect:/shop";
    }

    @GetMapping("/oauth/kakao/callback")
    public String kakaoCallback(String code) {
//        System.out.println("콜백 완료 : " + code);
        User sessionUser = userService.카카오로그인(code);
        session.setAttribute("sessionUser", sessionUser);
        return "redirect:/shop";
    }

    @GetMapping("/join-form")
    public String joinForm() {

        return "join-form";
    }

    @GetMapping("/login-form")
    public String loginForm() {
        return "login-form";
    }

    @PostMapping("/join")
    public String join(String username, String password, String email) {
        userService.회원가입(username, password, email);
        return "redirect:/login-form";
    }

    @PostMapping("/login")
    public String login(String username, String password) {
        User sessionUser = userService.로그인(username, password);
        session.setAttribute("sessionUser", sessionUser);
        return "redirect:/shop";
    }
}
