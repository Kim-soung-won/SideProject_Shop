package com.i.minishopping.Mapper.MProduct;

import com.i.minishopping.DTOResponse.Manage.MBrandListResponse;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface MBrandMapper {
    List<MBrandListResponse> getBrandDetails();
}