package com.i.minishopping.Repositorys.Product;

import com.i.minishopping.Domains.Product.Brands;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BrandsRepository extends JpaRepository<Brands, Long>{
    @Query("SELECT b FROM Brands b WHERE b.brand_name = ?1")
    Brands findByBrandName(String brandName);
}