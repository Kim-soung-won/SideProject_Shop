package com.i.minishopping.Config.Security;


import com.i.minishopping.Domains.ENUM.DOIT;
import com.i.minishopping.Domains.User.UserLog;
import com.i.minishopping.Services.User.UserLogService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutHandler;

@RequiredArgsConstructor
public class CustomLogoutHandler implements LogoutHandler {
    private final Logger logger = LoggerFactory.getLogger(SpringApplication.class);
    private final UserLogService userLogService;
    @Override
    public void logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
        response.setStatus(HttpServletResponse.SC_OK);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        logger.info("logout success : "+authentication.getName());
        userLogService.saveUserLog(authentication.getName(), DOIT.LOGOUT);
    }
}
