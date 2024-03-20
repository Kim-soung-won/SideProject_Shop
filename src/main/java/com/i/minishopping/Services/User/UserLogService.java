package com.i.minishopping.Services.User;

import com.i.minishopping.Domains.ENUM.DOIT;
import com.i.minishopping.Domains.User.UserLog;
import com.i.minishopping.Repositorys.User.UserLogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class UserLogService {
    private final UserLogRepository userLogRepository;

    public void saveUserLog(Long id, DOIT action) {
        userLogRepository.save(UserLog.builder()
                        .user_id(id)
                        .created_at(LocalDateTime.now())
                        .doit(action)
                .build());
    }
}
