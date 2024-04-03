package com.i.minishopping.Services.User;

import com.i.minishopping.Domains.User.UserInfo;
import com.i.minishopping.Repositorys.User.UserInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserInfoService {
    private final UserInfoRepository userDetailRepository;

    @Transactional(readOnly = true)
    public UserInfo findById(Long id){
        return userDetailRepository.findById(id).orElse(null);
    }


}
