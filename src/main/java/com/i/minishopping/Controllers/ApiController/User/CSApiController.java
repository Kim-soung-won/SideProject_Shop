package com.i.minishopping.Controllers.ApiController.User;

import com.i.minishopping.DTO.User.AddCSRequest;
import com.i.minishopping.DTO.User.AddCSResponse;
import com.i.minishopping.Domains.EMBEDDED.Created;
import com.i.minishopping.Domains.User.CS;
import com.i.minishopping.Domains.User.User;
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
    public ResponseEntity<AddCSResponse> saveCS(@RequestBody @Valid AddCSRequest request, HttpSession session){
        User user = (User) session.getAttribute("user");
        System.out.println(user);
        if(user==null){
            return ResponseEntity.badRequest().body(new AddCSResponse("로그인이 필요합니다."));
        }
        Created created = new Created(user, LocalDateTime.now());
        CS cs = csService.saveCS(request, created);
        return ResponseEntity.ok().body(new AddCSResponse("문의가 완료되었습니다."));
    }
}
