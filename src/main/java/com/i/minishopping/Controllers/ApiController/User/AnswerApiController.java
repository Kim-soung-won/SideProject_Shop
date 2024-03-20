package com.i.minishopping.Controllers.ApiController.User;

import com.i.minishopping.DTO.User.AddAnswerRequest;
import com.i.minishopping.Domains.EMBEDDED.Created;
import com.i.minishopping.Domains.User.User;
import com.i.minishopping.Services.User.AnswerService;
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
public class AnswerApiController {
    private final AnswerService answerService;
    private final CSService csService;
    @PostMapping("/api/POST/answer")
    public ResponseEntity<String> saveAnswer(@RequestBody @Valid AddAnswerRequest request, HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user == null) {
            return ResponseEntity.badRequest().body("로그인이 필요합니다.");
        }
        Created created = new Created(user, LocalDateTime.now());
        String answer = answerService.saveAnswer(request, created);
        return ResponseEntity.ok().body(answer);
    }
}
