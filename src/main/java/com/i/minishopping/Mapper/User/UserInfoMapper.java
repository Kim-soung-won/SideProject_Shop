package com.i.minishopping.Mapper.User;

import com.i.minishopping.Mapper.DTO.InfoData;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface UserInfoMapper {
    void infoSet(@Param("data")InfoData data);

    Long infoGet(@Param("user_id") Long id);
}
