package com.i.minishopping.Services.User;

import com.i.minishopping.DTO.User.UserJoinRequest;
import com.i.minishopping.DTO.User.UserLoginRequest;
import com.i.minishopping.Domains.User.Member;
import com.i.minishopping.Repositorys.User.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public Member checkEmail(String email){
        return userRepository.findByEmail(email);
    }
    public void saveUser(UserJoinRequest request) {
        userRepository.save(request.toEntity(passwordEncoder));
    }

    public Member findById(Long id) {
        return userRepository.findById(id).orElseThrow();
    }
    public Member findByEmail(String email) {
        return userRepository.findByEmail(email);
    }


//    @Transactional
//    public Member login(UserLoginRequest request){
//        System.out.println("11111111111111111");
//        Member member = userRepository.findByEmail(request.getEmail());
//        System.out.println("member" + member.getId());
//        if (passwordEncoder.matches(member.getPassword(), request.getPassword()))
//            return member;
//        else
//            return null;
//    }

    @Async
    public void async(){
        for(int i=0; i<10; i++) {
            System.out.println("1111111111111");
        }
    }

    @Async
    public void async2(){
        for(int i=0; i<10; i++) {
            System.out.println("222222222222");
        }
    }
}
