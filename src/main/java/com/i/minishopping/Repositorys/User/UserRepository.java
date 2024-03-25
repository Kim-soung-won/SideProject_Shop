package com.i.minishopping.Repositorys.User;

import com.i.minishopping.Domains.User.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<UserAccount, Long> {

    @Query("SELECT u FROM UserAccount u WHERE u.email = :email")
    UserAccount findByEmail(String email);
}
