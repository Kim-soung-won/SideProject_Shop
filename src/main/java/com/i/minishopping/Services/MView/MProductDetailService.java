package com.i.minishopping.Services.MView;


import com.i.minishopping.DTOResponse.Manage.MProductDetailView;
import com.i.minishopping.Mapper.MProduct.MProductMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MProductDetailService {
    private final MProductMapper mapper;

    @Transactional(readOnly = true)
    public MProductDetailView getDetail(Long id) {
        return mapper.getDetail(id);
    }
}
