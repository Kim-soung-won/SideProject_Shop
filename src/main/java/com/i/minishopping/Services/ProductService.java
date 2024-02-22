package com.i.minishopping.Services;

import com.i.minishopping.DTO.Product.AddProductRequest;
import com.i.minishopping.Domains.EMBEDDED.Created;
import com.i.minishopping.Domains.Product;
import com.i.minishopping.Repositorys.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    @Transactional
    public void saveManyProduct(Product product){
        productRepository.save(product);
    }
    @Transactional
    public Product saveOneProduct(AddProductRequest request, Created created) {

        return productRepository.save(Product.builder()
                .name(request.getName())
                .price(request.getPrice())
                .brandName(request.getBrandName())
                .category(request.getCategory())
                .beforeCount(request.getBeforeCount())
                .created(created)
                .build());
    }
    public Product findById(Long id){
        return productRepository.findById(id).orElseThrow();
    }
}
