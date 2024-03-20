package com.i.minishopping.Repositorys.User;

import com.i.minishopping.Domains.User.CS;
import com.i.minishopping.Domains.User.CS_Answer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswerRepository extends JpaRepository<CS_Answer, CS> {
}
