package com.i.minishopping.Services.User;

import com.i.minishopping.Domains.ENUM.DOIT;
import com.i.minishopping.Domains.User.Cart;
import com.i.minishopping.Domains.User.Love;
import com.i.minishopping.Domains.User.UserInfo;
import com.i.minishopping.Domains.User.UserAccount;
import com.i.minishopping.Repositorys.User.*;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LoginService {
    private final UserRepository userRepository;
    private final UserInfoRepository userInfoRepository;
    private final LoveRepository loveRepository;
    private final CartRepository cartRepository;
    private final UserLogService userLogService;

    @Transactional
    public void setSession(String email, HttpSession session){
        UserAccount account = findByEmail(email);
        UserInfo user = findById(account.getId());
        List<Love> loves = findLoveByUserId(user);
        List<Cart> carts = findCartByUserId(user);
        session.setAttribute("user", user);
        session.setAttribute("loves", loves);
        session.setAttribute("carts", carts);
        session.setMaxInactiveInterval(60*60*24*30);  //세션 유효시간 결정(초단위)
        userLogService.saveUserLog(user.getId(), user.getName(), DOIT.LOGIN);
    }

    @Transactional
    public UserAccount findByEmail(String email){
        return userRepository.findByEmail(email);
    }
    public UserInfo findById(Long id){
        return userInfoRepository.findById(id).orElse(null);
    }
    @Transactional
    public List<Love> findLoveByUserId(UserInfo user){
        return loveRepository.findByUserId(user);
    }
    @Transactional
    public List<Cart> findCartByUserId(UserInfo user){
        return cartRepository.findByUserId(user);
    }
}
