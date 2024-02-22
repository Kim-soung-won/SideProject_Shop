package com.i.minishopping.Controllers.ApiController.User;

import com.i.minishopping.Domains.ENUM.ROLE;
import com.i.minishopping.Domains.User;
import com.i.minishopping.Services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserApiController {

    private final UserService userService;

    @PostMapping("/api/POST/user")
    public void saveUser() {
        User user = new User();
        user.setEmail("1234");
        user.setPassword("1234");
        user.setRole(ROLE.ROLE_USER);
        user.setPnum("010-1234-5678");
        userService.saveUser(user);
    }
}
