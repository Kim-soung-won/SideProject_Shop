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

    public void saveUserLog(Long id, String name, DOIT action) {
        userLogRepository.save(UserLog.builder()
                        .id(id)
                        .name(name)
                        .created_at(LocalDateTime.now())
                        .doit(action)
                .build());
    }
}
