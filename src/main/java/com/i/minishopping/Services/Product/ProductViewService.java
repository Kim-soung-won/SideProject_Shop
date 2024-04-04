package com.i.minishopping.Services.Product;

import com.i.minishopping.DTOResponse.Manage.MProductListView;
import com.i.minishopping.Domains.Product.Product;
import com.i.minishopping.Repositorys.Product.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class ProductViewService {
    private final ProductRepository productRepository;

    @Transactional(readOnly = true)
    public List<Product> findAllByPage(Pageable page){
        return productRepository.findAllByPage(page).orElseThrow(()->new IllegalArgumentException("어어 없내용?"));
    }
    @Transactional(readOnly = true)
    public List<Product> findByCategory(Pageable page, String category){
        return productRepository.findByCategory(page,category).orElseThrow(()->new IllegalArgumentException("어어 없내용?"));
    }
    @Transactional(readOnly = true)
    public List<Product> findPopularList(Pageable page){
        return productRepository.findSortList(page).orElseThrow(()->new IllegalArgumentException("어어 없내용?"));
    }

    @Transactional(readOnly = true)
    public List<MProductListView> managePdList(Pageable page){
        return productRepository.MProductView(page).orElseThrow(()->new IllegalArgumentException("어어 없내용?"));
    }

    @Transactional(readOnly = true)
    public List<MProductListView> managePdListByName(Pageable page, String name){
        return productRepository.MProductViewByName(page, name).orElseThrow(()->new IllegalArgumentException("어어 없내용?"));
    }

    @Transactional(readOnly = true)
    public List<MProductListView> managePdListByNameOrderByPrice(Pageable page, String name, String order){
        return productRepository.MProductViewByNameOrderByPrice(page, name, order).orElseThrow(()->new IllegalArgumentException("어어 없내용?"));
    }

    @Transactional(readOnly = true)
    public List<MProductListView> managePdListByNameOrderByAmount(Pageable page, String name, String order){
        return productRepository.MProductViewByNameOrderByAmount(page, name, order).orElseThrow(()->new IllegalArgumentException("어어 없내용?"));
    }

    @Transactional(readOnly = true)
    public List<MProductListView> managePdListByNameOrderBySales(Pageable page, String name, String order){
        return productRepository.MProductViewByNameOrderBySales(page, name, order).orElseThrow(()->new IllegalArgumentException("어어 없내용?"));
    }
}
