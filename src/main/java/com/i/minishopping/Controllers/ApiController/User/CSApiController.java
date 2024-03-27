package com.i.minishopping.Controllers.ApiController.User;

import com.i.minishopping.DTORequest.User.AddCSRequest;
import com.i.minishopping.Domains.EMBEDDED.Created;
import com.i.minishopping.Domains.User.CS;
import com.i.minishopping.Domains.User.UserInfo;
import com.i.minishopping.Services.User.CSService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequiredArgsConstructor
public class CSApiController {
    private final CSService csService;

    @PostMapping("/api/POST/cs")
    public ResponseEntity<String> saveCS(@RequestBody @Valid AddCSRequest request, HttpSession session){
        UserInfo user = (UserInfo) session.getAttribute("user");
        if(user==null){
            return ResponseEntity.badRequest().body("로그인이 필요합니다.");
        }
        Created created = new Created(user, LocalDateTime.now());
        CS cs = csService.saveCS(request, created);
        return ResponseEntity.ok().body("문의가 등록되었습니다.");
    }
}
