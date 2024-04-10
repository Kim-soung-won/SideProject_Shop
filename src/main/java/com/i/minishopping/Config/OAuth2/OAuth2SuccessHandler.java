package com.i.minishopping.Config.OAuth2;


import com.i.minishopping.Domains.User.UserAccount;
import com.i.minishopping.Mapper.DTO.InfoData;
import com.i.minishopping.Mapper.User.UserInfoMapper;
import com.i.minishopping.Repositorys.User.UserRepository;
import com.i.minishopping.Services.User.LoginService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import java.io.IOException;

@RequiredArgsConstructor
public class OAuth2SuccessHandler implements AuthenticationSuccessHandler {
    private final LoginService loginService;
    private final UserRepository userRepository;
    private final UserInfoMapper userInfoMapper;
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        DefaultOAuth2User user = (DefaultOAuth2User) authentication.getPrincipal();
        String email = user.getAttribute("email").toString();
        UserAccount account = userRepository.findByEmail(email);
        System.out.println(account);
        System.out.println("id : "+ account.getId());
        Long info = userInfoMapper.infoGet(account.getId());
        if(info == null){
            userInfoMapper.infoSet(new InfoData(account.getId(), user.getAttribute("sub").toString()));
        }
        loginService.setSession(email, request.getSession());
        response.sendRedirect("/productList");
        System.out.println("user = " + user.getAttributes());
    }
}
