package com.i.minishopping.Services.User;

import com.i.minishopping.DTORequest.User.AddCSRequest;
import com.i.minishopping.Domains.EMBEDDED.Created;
import com.i.minishopping.Domains.ENUM.CS_STATE;
import com.i.minishopping.Domains.User.CS;
import com.i.minishopping.Repositorys.User.CSRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CSService {
    private final CSRepository csRepository;

    @Transactional
    public CS saveCS(AddCSRequest request, Created created) {
        return csRepository.save(CS.builder()
                .created(created)
                .category(request.getCategory())
                .content(request.getContent())
                .state(CS_STATE.WAIT)
                .build());
    }

    @Transactional(readOnly = true)
    public CS findById(Long id) {
        System.out.println(id);
        return csRepository.findById(id).orElse(null);
    }
}
