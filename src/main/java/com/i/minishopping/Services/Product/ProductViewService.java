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
    public List<Product> findByCategory(Pageable page, String category){
        return productRepository.findByCategory(page,category).orElseThrow(()->new IllegalArgumentException("어어 없내용?"));
    }
    public List<Product> findPopularList(Pageable page){
        return productRepository.findSortList(page).orElseThrow(()->new IllegalArgumentException("어어 없내용?"));
    }
    public List<Product> findLatestList(Pageable page){
        return productRepository.findLatestList(page).orElseThrow(()->new IllegalArgumentException("어어 없내용?"));
    }
    public List<Product> findHighPriceList(Pageable page){
        return productRepository.findHighPriceList(page).orElseThrow(()->new IllegalArgumentException("어어 없내용?"));
    }
    public List<Product> findLowPriceList(Pageable page){
        return productRepository.findLowPriceList(page).orElseThrow(()->new IllegalArgumentException("어어 없내용?"));
    }
}
