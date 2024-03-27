package com.i.minishopping.Controllers.ApiController.User;

import com.i.minishopping.DTOResponse.Common.CommonResponse;
import com.i.minishopping.DTORequest.User.UserEmailCheckRequest;
import com.i.minishopping.DTORequest.User.UserJoinRequest;
import com.i.minishopping.Domains.User.UserInfo;
import com.i.minishopping.Domains.User.UserAccount;
import com.i.minishopping.Services.User.UserInfoService;
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

    private final UserInfoService userInfoService;
    private final UserService userService;
    private final UserLogService log;
    @PostMapping("/api/POST/user") //회원가입
    public ResponseEntity<CommonResponse> saveUser(@RequestBody @Valid UserJoinRequest request) {
        userService.saveUser(request);
        CommonResponse response = new CommonResponse(200, "회원가입 성공");
        return ResponseEntity.ok().body(response);
    }

    @PostMapping("/api/POST/checkEmail") //이메일 같은거 있는지 체크
    public ResponseEntity<CommonResponse> checkEmail(@RequestBody @Valid UserEmailCheckRequest request) {
        UserAccount user = userService.checkEmail(request.getEmail());
        if(user != null)
            return ResponseEntity.ok().body(new CommonResponse(400, "이미 사용중인 이메일 입니다."));
        return ResponseEntity.ok().body(new CommonResponse(200, "사용 가능한 이메일 입니다."));
    }

    @PostMapping("/login") //Postman용 로그인 
    public void testlogin(HttpSession session){
        UserInfo userInfo = userInfoService.findById(1L);
        session.setAttribute("user", userInfo);
    }

    
//    @PostMapping("/test/async") //비동기 처리 테스트
//    public void asyncTest() {
//        userService.async();
//        userService.async2();
//    }
}
