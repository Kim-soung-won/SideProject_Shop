package com.i.minishopping.Services.User;

import com.i.minishopping.DTORequest.User.UserJoinRequest;
import com.i.minishopping.Domains.User.UserAccount;
import com.i.minishopping.Repositorys.User.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional(readOnly = true)
    public UserAccount checkEmail(String email){
        return userRepository.findByEmail(email);
    }
    @Transactional
    public void saveUser(UserJoinRequest request) {
        userRepository.save(request.toEntity(passwordEncoder));
    }

    @Transactional(readOnly = true)
    public UserAccount findById(Long id) {
        return userRepository.findById(id).orElseThrow();
    }
    @Transactional(readOnly = true)
    public UserAccount findByEmail(String email) {
        return userRepository.findByEmail(email);
    }


//    @Transactional
//    public UserAccount login(UserLoginRequest request){
//        System.out.println("11111111111111111");
//        UserAccount member = userRepository.findByEmail(request.getEmail());
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
