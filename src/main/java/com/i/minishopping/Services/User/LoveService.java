package com.i.minishopping.Services.User;

import com.i.minishopping.Domains.EMBEDDED.Love_key;
import com.i.minishopping.Domains.ENUM.DOIT;
import com.i.minishopping.Domains.User.Love;
import com.i.minishopping.Domains.Product.Product;
import com.i.minishopping.Domains.User.UserInfo;
import com.i.minishopping.Repositorys.User.LoveRepository;
import com.i.minishopping.Services.Product.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LoveService {
    private final LoveRepository loveRepository;
    private final ProductService productService;
    private final UserLogService log;
    public int countByUserId(Product product){
        return loveRepository.countByUserId(product);
    }

    @Transactional
    public Love findById(Love_key key) {
        Love love = loveRepository.findById(key).orElse(null);
        return love;
    }
    @Transactional
    public Love saveLove(Love_key key){
        return loveRepository.save(
                Love.builder()
                .love_key(key)
                .created_at(LocalDateTime.now())
                .build());
    }

    @Transactional
    public List<Love> findByUserId(Long id){
        return loveRepository.findByUserId(id);
    }
    @Transactional
    public Love clickLove(UserInfo user, Product product) {
        Love_key key = new Love_key(user, product);
        Love love = findById(key);
        if (love == null) {
            productService.count_Love(1, product.getProduct_id());
            log.saveUserLog(user.getId(),user.getName(), DOIT.LOVE);
            return saveLove(key);
        } else {
            deleteLove(love.getLove_key());
            productService.count_Love(-1, product.getProduct_id());
            return null;
        }
    }
    @Transactional
    public void deleteLove(Love_key id){
        Love love = loveRepository.findById(id).
                orElseThrow(() -> new IllegalArgumentException("not found: " + id));
        loveRepository.delete(love);
    }
}
