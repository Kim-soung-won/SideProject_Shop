package com.i.minishopping.Repositorys.Product;

import com.i.minishopping.Domains.EMBEDDED.Product_log_key;
import com.i.minishopping.Domains.Product.Product_Log;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PdLogRepository extends JpaRepository<Product_Log, Product_log_key> {
}
