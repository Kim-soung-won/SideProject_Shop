package com.i.minishopping.Config.Security;

import com.i.minishopping.Domains.ENUM.DOIT;
import com.i.minishopping.Domains.User.UserAccount;
import com.i.minishopping.Domains.User.UserInfo;
import com.i.minishopping.Repositorys.User.UserRepository;
import com.i.minishopping.Services.User.LoginService;
import com.i.minishopping.Services.User.UserInfoService;
import com.i.minishopping.Services.User.UserLogService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import java.io.IOException;

@RequiredArgsConstructor
@Slf4j
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
    private final LoginService loginService;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response
            , Authentication authentication) throws IOException, ServletException {
        response.setStatus(HttpServletResponse.SC_OK);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write("{\"success\": true}");
        String email = authentication.getName();
        log.info("login success : "+email);
        System.out.println("login success : "+email);
        loginService.setSession(email, request.getSession());
        response.sendRedirect("/productList");
    }
}
