package com.i.minishopping.Repositorys.User;

import com.i.minishopping.Domains.User.User_account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User_account, Long> {

    @Query("SELECT u FROM User_account u WHERE u.email = :email")
    User_account findByEmail(String email);
}
