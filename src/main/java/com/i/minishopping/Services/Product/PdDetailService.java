package com.i.minishopping.Services.Product;

import com.i.minishopping.Domains.EMBEDDED.Product_Detail_key;
import com.i.minishopping.Domains.Product.ProductDetail;
import com.i.minishopping.Repositorys.Product.PdDetailRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PdDetailService {
    private final PdDetailRepository pdDetailRepository;

    @Transactional
    public ProductDetail save(Product_Detail_key key, int beforeCount) {
        return pdDetailRepository.save(ProductDetail.builder()
                .product_detail_key(key)
                .beforeCount(beforeCount)
                .build());
    }
    @Transactional
    public void sellCount(int count, Product_Detail_key key) {
        ProductDetail productDetail = pdDetailRepository.findById(key).
                orElseThrow(() -> new IllegalArgumentException("not found: Product, size"));
        productDetail.sellPd(count);
    }
}