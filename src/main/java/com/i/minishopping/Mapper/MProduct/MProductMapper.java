package com.i.minishopping.Mapper.MProduct;

import com.i.minishopping.DTOResponse.Manage.MProductDetailView;
import com.i.minishopping.DTOResponse.Manage.MProductListView;
import com.i.minishopping.Mapper.DTO.MProductSortAndOrder;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface MProductMapper {
    List<MProductListView> sortAndSearch(@Param("data")MProductSortAndOrder data);

    MProductDetailView getDetail(Long id);
}
