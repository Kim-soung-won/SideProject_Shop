package com.i.minishopping.Services.User;

import com.i.minishopping.DTO.User.AddCSRequest;
import com.i.minishopping.Domains.EMBEDDED.Created;
import com.i.minishopping.Domains.ENUM.CS_STATE;
import com.i.minishopping.Domains.User.CS;
import com.i.minishopping.Repositorys.User.CSRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CSService {
    private final CSRepository csRepository;

    public CS saveCS(AddCSRequest request, Created created) {
        return csRepository.save(CS.builder()
                .created(created)
                .category(request.getCategory())
                .content(request.getContent())
                .state(CS_STATE.WAIT)
                .build());
    }
}
