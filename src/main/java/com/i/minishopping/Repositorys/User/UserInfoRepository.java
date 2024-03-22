package com.i.minishopping.Repositorys.User;

import com.i.minishopping.Domains.User.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserInfoRepository extends JpaRepository<UserInfo, Long> {
}
