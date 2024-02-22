package com.i.minishopping.Repositorys;

import com.i.minishopping.Domains.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
