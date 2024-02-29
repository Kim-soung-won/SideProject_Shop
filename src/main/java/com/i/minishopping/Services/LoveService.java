package com.i.minishopping.Services;

import com.i.minishopping.DTO.Love.AddLoveRequest;
import com.i.minishopping.Domains.EMBEDDED.Created;
import com.i.minishopping.Domains.Love;
import com.i.minishopping.Domains.Product;
import com.i.minishopping.Domains.User;
import com.i.minishopping.Repositorys.LoveRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LoveService {
    private final LoveRepository loveRepository;
    public int countByUserId(Product product){
        return loveRepository.countByUserId(product);
    }
    @Transactional
    public Love findByLove(Product product, User created_who){
        Love love = loveRepository.findByLove(product, created_who);
        System.out.println("love = " + love);
        return love;
    }
    public Love findById(Long id) {
        Love love = loveRepository.findById(id).orElse(null);
        return love;
    }
    @Transactional
    public void saveLove(Product product, Created created){
        loveRepository.save(
                Love.builder()
                .product_id(product)
                .created(created)
                .build());
    }
    @Transactional
    public void deleteLove(Long id){
        Love love = loveRepository.findById(id).
                orElseThrow(() -> new IllegalArgumentException("not found: " + id));
        loveRepository.delete(love);
        long beforeTime = System.currentTimeMillis();
        System.out.println("DELETE : "+beforeTime);
    }
}
