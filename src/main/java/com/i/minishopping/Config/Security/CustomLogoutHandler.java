package com.i.minishopping.Config.Security;


import com.i.minishopping.Domains.ENUM.DOIT;
import com.i.minishopping.Domains.User.UserInfo;
import com.i.minishopping.Services.User.UserLogService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
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
        removeSessionData(request.getSession());
        logger.info("logout success : "+authentication.getName());
    }

    public void removeSessionData(HttpSession session){
        UserInfo userInfo = (UserInfo) session.getAttribute("user");
        userLogService.saveUserLog(userInfo.getId(), userInfo.getName(), DOIT.LOGOUT);
        //session.invalidate(); // 현재 세션을 즉시 무효화
        session.removeAttribute("user"); // "user" 속성만 세션에서 제거
    }
}
