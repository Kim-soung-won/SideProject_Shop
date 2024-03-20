package com.i.minishopping.Services.User;

import com.i.minishopping.Domains.User.User;
import com.i.minishopping.Repositorys.User.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    public void saveUser(User user) {
        userRepository.save(user);
    }

    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow();
    }

    @Transactional
    public User login(Long id) {
        User user = userRepository.findById(id).orElseThrow();
        user.updateLastLogin(LocalDateTime.now());
        return user;
    }
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
