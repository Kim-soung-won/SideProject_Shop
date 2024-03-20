package com.i.minishopping.Controllers.ApiController.User;

import com.i.minishopping.Domains.ENUM.DOIT;
import com.i.minishopping.Domains.ENUM.ROLE;
import com.i.minishopping.Domains.User.User;
import com.i.minishopping.Services.User.UserLogService;
import com.i.minishopping.Services.User.UserService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequiredArgsConstructor
@SessionAttributes("user")
public class UserApiController {

    private final UserService userService;
    private final UserLogService log;
    @PostMapping("/api/POST/user")
    public void saveUser() {
        System.out.println("11");
        User user = new User();
        user.setEmail("test2email@gmail.com");
        user.setPassword("Abcd1234!5678@");
        user.setRole(ROLE.ROLE_USER);
        user.setPnum("010-1234-5678");
        userService.saveUser(user);
    }

    @GetMapping("/api/GET/login")
    public void login(HttpSession session) {
        User user = userService.login(2L);
        log.saveUserLog(user.getId(), DOIT.LOGIN);
//        session.setMaxInactiveInterval(60*60*24*30); 세션 유효시간 결정(초단위)
        session.setAttribute("user", user);
    }

    @GetMapping("/api/GET/logout")
    public void logout(HttpSession session) {
        session.invalidate();
    }

    @PostMapping("/test/async")
    public void asyncTest() {
        userService.async();
        userService.async2();
    }
}
