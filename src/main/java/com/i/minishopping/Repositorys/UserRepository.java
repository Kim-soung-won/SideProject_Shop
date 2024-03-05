package com.i.minishopping.Repositorys;

import com.i.minishopping.Domains.User.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
