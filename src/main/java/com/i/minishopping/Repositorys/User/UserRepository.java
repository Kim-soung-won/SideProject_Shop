package com.i.minishopping.Repositorys.User;

import com.i.minishopping.Domains.User.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<Member, Long> {

    @Query("SELECT u FROM Member u WHERE u.email = :email")
    Member findByEmail(String email);
}
