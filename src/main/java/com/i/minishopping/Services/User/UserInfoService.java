package com.i.minishopping.Services.User;

import com.i.minishopping.Domains.User.UserInfo;
import com.i.minishopping.Repositorys.User.UserInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserInfoService {
    private final UserInfoRepository userDetailRepository;

    public UserInfo findById(Long id){
        return userDetailRepository.findById(id).orElse(null);
    }


}
