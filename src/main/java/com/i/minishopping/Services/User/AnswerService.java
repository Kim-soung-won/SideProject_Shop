package com.i.minishopping.Services.User;

import com.i.minishopping.DTO.User.AddAnswerRequest;
import com.i.minishopping.Domains.EMBEDDED.Created;
import com.i.minishopping.Domains.User.CS;
import com.i.minishopping.Domains.User.CS_Answer;
import com.i.minishopping.Repositorys.User.AnswerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AnswerService {
    private final AnswerRepository answerRepository;
    private final CSService csService;

    @Transactional
    public String saveAnswer(AddAnswerRequest request, Created created ) {
        CS cs = csService.findById(request.getId());
        if(cs==null){
            return "존재하지 않는 문의입니다.";
        }
        answerRepository.save(CS_Answer.builder()
                        .content(request.getContent())
                        .created(created)
                        .cs(csService.findById(request.getId()))
                .build());
        return "답변이 등록되었습니다.";
    }
}
