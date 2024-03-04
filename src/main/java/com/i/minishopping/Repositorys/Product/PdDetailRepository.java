package com.i.minishopping.Repositorys.Product;

import com.i.minishopping.Domains.EMBEDDED.Product_Detail_key;
import com.i.minishopping.Domains.Product.ProductDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PdDetailRepository extends JpaRepository<ProductDetail, Product_Detail_key> {

}
