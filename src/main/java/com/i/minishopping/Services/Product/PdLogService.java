package com.i.minishopping.Services.Product;

import com.i.minishopping.Domains.EMBEDDED.Product_log_key;
import com.i.minishopping.Domains.Product.Product_Log;
import com.i.minishopping.Repositorys.Product.PdLogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PdLogService {
    private final PdLogRepository pdLogRepository;
    @Transactional
    public Product_Log saveLog(Product_log_key key, String size, int count) {
        return pdLogRepository.save(Product_Log.builder()
                .product_log_key(key)
                .size(size)
                .count(count)
                .build());
    }
}
