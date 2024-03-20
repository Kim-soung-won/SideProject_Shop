package com.i.minishopping.Repositorys.User;

import com.i.minishopping.Domains.User.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
