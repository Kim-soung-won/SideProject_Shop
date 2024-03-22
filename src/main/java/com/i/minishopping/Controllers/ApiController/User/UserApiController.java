package com.i.minishopping.Controllers.ApiController.User;

import com.i.minishopping.DTO.Common.CommonResponse;
import com.i.minishopping.DTO.User.UserEmailCheckRequest;
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

import java.util.Objects;

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

    @PostMapping("/api/POST/checkEmail")
    public ResponseEntity<CommonResponse> checkEmail(@RequestBody @Valid UserEmailCheckRequest request) {
        Member user = userService.checkEmail(request.getEmail());
        if(user != null)
            return ResponseEntity.ok().body(new CommonResponse(400, "이미 사용중인 이메일 입니다."));
        return ResponseEntity.ok().body(new CommonResponse(200, "사용 가능한 이메일 입니다."));
    }



    @PostMapping("/test/async")
    public void asyncTest() {
        userService.async();
        userService.async2();
    }
}
