package com.i.minishopping.Services.Product;

import com.i.minishopping.DTORequest.Product.AddProductRequest;
import com.i.minishopping.DTORequest.Product.UpdateProductRequest;
import com.i.minishopping.Domains.EMBEDDED.Created;
import com.i.minishopping.Domains.Product.Product;
import com.i.minishopping.Repositorys.Product.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final BrandService brandsService;
    @Transactional
    public void saveManyProduct(Product product){
        productRepository.save(product);
    }
    @Transactional
    public Product saveOneProduct(AddProductRequest request, Created created) {
        return productRepository.save(Product.builder()
                .name(request.getName())
                .price(request.getPrice())
                .brand_id(brandsService.findByName(request.getBrandName()))
                .category(request.getCategory())
                .created(created)
                .build());
    }
    @Transactional
    public Product updateOneProduct(UpdateProductRequest request, Created created) {
        Product product = productRepository.findById(request.getId()).orElseThrow(()->new IllegalArgumentException("not found: " + request.getId()));
        product.updateProduct(request.getName(), request.getPrice(), request.getCategory(), created);
        return product;
    }
    @Transactional(readOnly = true)
    public Product findById(Long id){
        return productRepository.findById(id).orElse(null);

    }

    public void count_Love(int val, Long id) {
        productRepository.updateCount(val, id);
        long beforeTime = System.currentTimeMillis();
    }
    @Transactional
    public Product deleteOneProduct(Long id){
        Product product = productRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("not found : " + id));
        productRepository.delete(product);
        return product;
    }
}
