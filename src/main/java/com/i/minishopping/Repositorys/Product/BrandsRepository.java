package com.i.minishopping.Repositorys.Product;

import com.i.minishopping.Domains.Product.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BrandsRepository extends JpaRepository<Brand, Long>{
    @Query("SELECT b FROM Brand b WHERE b.brand_name = ?1")
    Brand findByBrandName(String brandName);
}
