package com.i.minishopping.Mapper.User;

import com.i.minishopping.Mapper.DTO.UserAccountBatis;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserAccountMapper {
    UserAccountBatis findByEmail(String email);

    Long saveUserAccount(@Param("userAccount") UserAccountBatis userAccountDTO);
}
