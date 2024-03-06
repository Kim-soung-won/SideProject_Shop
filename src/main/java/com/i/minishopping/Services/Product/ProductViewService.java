package com.i.minishopping.Services.Product;

import com.i.minishopping.Domains.Product.Product;
import com.i.minishopping.Repositorys.Product.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductViewService {
    private final ProductRepository productRepository;

    public List<Product> findAllByPage(Pageable page){
        return productRepository.findAllByPage(page).orElseThrow(()->new IllegalArgumentException("어어 없내용?"));
    }
}
