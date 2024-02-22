package com.i.minishopping.Services;

import com.i.minishopping.Domains.User;
import com.i.minishopping.Repositorys.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    public void saveUser(User user) {
        userRepository.save(user);
    }

    public User findById(Long id){
        return userRepository.findById(id).orElseThrow();
    }
}
