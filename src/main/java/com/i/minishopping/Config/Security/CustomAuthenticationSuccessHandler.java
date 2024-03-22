package com.i.minishopping.Config.Security;

import com.i.minishopping.Domains.ENUM.DOIT;
import com.i.minishopping.Domains.User.User_account;
import com.i.minishopping.Domains.User.UserInfo;
import com.i.minishopping.Repositorys.User.UserRepository;
import com.i.minishopping.Services.User.UserInfoService;
import com.i.minishopping.Services.User.UserLogService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import java.io.IOException;

@RequiredArgsConstructor
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
    private final Logger logger = LoggerFactory.getLogger(SpringApplication.class);
    private final UserLogService userLogService;
    private final UserRepository userService;
    private final UserInfoService userInfoService;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        response.setStatus(HttpServletResponse.SC_OK);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write("{\"success\": true}");
        String email = authentication.getName();
        logger.info("login success : "+email);
        setSessionData(request.getSession(), email);
    }

    public void setSessionData(HttpSession session, String email){
        User_account user = userService.findByEmail(email);
        UserInfo userInfo = userInfoService.findById(user.getId());
        session.setMaxInactiveInterval(60*60*24*30);  //세션 유효시간 결정(초단위)
        session.setAttribute("user", userInfo);
        userLogService.saveUserLog(userInfo.getId(), userInfo.getName(), DOIT.LOGIN);
    }
}
