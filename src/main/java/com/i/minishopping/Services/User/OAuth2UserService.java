package com.i.minishopping.Services.User;

import com.i.minishopping.Domains.ENUM.ROLE;
import com.i.minishopping.Domains.User.UserAccount;
import com.i.minishopping.Domains.User.UserInfo;
import com.i.minishopping.Mapper.DTO.UserAccountBatis;
import com.i.minishopping.Mapper.User.UserAccountMapper;
import com.i.minishopping.Repositorys.User.UserInfoRepository;
import com.i.minishopping.Repositorys.User.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class OAuth2UserService extends DefaultOAuth2UserService {

    private final UserAccountMapper userAccountMapper;
    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        String email = (String) super.loadUser(userRequest).getAttributes().get("email");
        String name = (String) super.loadUser(userRequest).getAttributes().get("sub");
        System.out.println("userRequest = " + userRequest.getClientRegistration().getRegistrationId()); // 어느 플랫폼으로 로그인했는지
        System.out.println("userRequest = " + super.loadUser(userRequest).getAttributes());
        System.out.println("userRequest = " + super.loadUser(userRequest).getAttributes().get("email"));
        System.out.println("userRequest = " + super.loadUser(userRequest).getAttributes().get("name"));
        System.out.println(email);

        OAuth2User oAuth2User = super.loadUser(userRequest);
        isExist(email, name);

        return super.loadUser(userRequest);
    }
    @Transactional
    public void isExist(String email, String name) {
        UserAccountBatis user = userAccountMapper.findByEmail(email);
        if(user == null){
            userAccountMapper.saveUserAccount(UserAccountBatis.builder()
                    .user_email(email)
                    .user_password(new BCryptPasswordEncoder().encode(name))
                    .user_role(UserAccountBatis.UserRole.USER)
                    .user_pnum("010-0000-0000")
                    .build());
        }
    }
}
