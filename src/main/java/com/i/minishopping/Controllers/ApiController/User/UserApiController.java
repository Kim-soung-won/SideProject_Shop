package com.i.minishopping.Controllers.ApiController.User;

import com.i.minishopping.DTO.Common.CommonResponse;
import com.i.minishopping.DTO.User.UserJoinRequest;
import com.i.minishopping.DTO.User.UserLoginRequest;
import com.i.minishopping.Domains.ENUM.DOIT;
import com.i.minishopping.Domains.User.Member;
import com.i.minishopping.Services.User.UserLogService;
import com.i.minishopping.Services.User.UserService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@SessionAttributes("user")
public class UserApiController {

    private final UserService userService;
    private final UserLogService log;
    @PostMapping("/api/POST/user")
    public ResponseEntity<CommonResponse> saveUser(@RequestBody @Valid UserJoinRequest request) {
        userService.saveUser(request);
        CommonResponse response = new CommonResponse(200, "회원가입 성공");
        return ResponseEntity.ok().body(response);
    }

//    @PostMapping("/api/POST/login")
//    public ResponseEntity<CommonResponse> login(@RequestBody @Valid UserLoginRequest request) {
//        System.out.println("11111111111111111");
//        System.out.println(request.getEmail());
//        Member member = userService.login(request);
//        if(member == null)
//             return ResponseEntity.ok().body(new CommonResponse(400, "로그인 실패"));
//        return ResponseEntity.ok().body(new CommonResponse(200, "로그인 성공"));
//    }

//    @GetMapping("/api/GET/login")
//    public void login(HttpSession session) {
//        Member user = userService.login(2L);
//        log.saveUserLog(user.getId(), DOIT.LOGIN);
////        session.setMaxInactiveInterval(60*60*24*30); 세션 유효시간 결정(초단위)
//        session.setAttribute("user", user);
//    }


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
