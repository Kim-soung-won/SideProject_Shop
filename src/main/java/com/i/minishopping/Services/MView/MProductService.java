package com.i.minishopping.Services.MView;

import com.i.minishopping.DTOResponse.Manage.MProductListView;
import com.i.minishopping.Mapper.DTO.MProductSortAndOrder;
import com.i.minishopping.Mapper.MProduct.MProductMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class MProductService {
    private final MProductMapper mapper;

    @Transactional(readOnly = true)
    public List<MProductListView> sortAndSearch(MProductSortAndOrder data) {
        System.out.println("result : "+mapper.sortAndSearch(data));
        return mapper.sortAndSearch(data);
    }
}
