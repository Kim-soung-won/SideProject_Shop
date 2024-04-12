package com.i.minishopping.Services.MView;

import com.i.minishopping.DTOResponse.Manage.MBrandListResponse;
import com.i.minishopping.Mapper.MProduct.MBrandMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MBrandService {
    private final MBrandMapper mapper;

    public List<MBrandListResponse> getBrandDetails(){
        return mapper.getBrandDetails();
    }
}
