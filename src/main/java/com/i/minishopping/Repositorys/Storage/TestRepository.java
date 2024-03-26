package com.i.minishopping.Repositorys.Storage;

import com.i.minishopping.Domains.test.UploadTest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestRepository extends JpaRepository<UploadTest, Long> {
}
