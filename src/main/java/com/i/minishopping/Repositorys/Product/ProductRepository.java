package com.i.minishopping.Repositorys.Product;

import com.i.minishopping.DTOResponse.Manage.MProductListView;
import com.i.minishopping.Domains.Product.Product;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
    @Modifying
    @Query("update Product set count_love = count_love+(:val) where product_id = :id")
    void updateCount(int val, Long id);

    @Query(value = "select * from product where pd_category like concat('%',:category,'%')", nativeQuery = true)
    Optional<List<Product>> findByCategory(Pageable pageable, String category);

    @Query(value = "select * from product order by count_love DESC", nativeQuery = true)
    Optional<List<Product>> findAllByPage(Pageable pageable);

    @Query(value = "select * from product", nativeQuery = true)
    Optional<List<Product>> findSortList(Pageable pageable);

    @Query("SELECT new com.i.minishopping.DTOResponse.Manage.MProductListView(p.product_id, b.brand_name, p.name, p.price, SUM(pd.beforeCount), SUM(pd.sellCount)) " +
            "FROM Product p " +
            "LEFT JOIN p.brand_id b " +
            "LEFT JOIN p.details pd " +
            "GROUP BY p.product_id")
    Optional<List<MProductListView>> MProductView(Pageable pageable);

//    @Query("SELECT new com.i.minishopping.DTOResponse.Manage.MProductListView(p.product_id, b.brand_name, p.name, p.price, SUM(pd.beforeCount), SUM(pd.sellCount)) " +
//            "FROM Product p " +
//            "LEFT JOIN p.brand_id b " +
//            "LEFT JOIN p.details pd " +
//            "WHERE p.name like concat('%',:name,'%') " +
//            "GROUP BY p.product_id")
//    Optional<List<MProductListView>> MProductViewByName(Pageable pageable, String name);
//
//    @Query("SELECT new com.i.minishopping.DTOResponse.Manage.MProductListView(p.product_id, b.brand_name, p.name, p.price, SUM(pd.beforeCount), SUM(pd.sellCount)) " +
//            "FROM Product p " +
//            "LEFT JOIN p.brand_id b " +
//            "LEFT JOIN p.details pd " +
//            "WHERE p.name like concat('%',:name,'%') " +
//            "GROUP BY p.product_id " +
//            "ORDER BY p.price ,:order")
//    Optional<List<MProductListView>> MProductViewByNameOrderByPrice(Pageable pageable, String name, String order);
//
//    @Query("SELECT new com.i.minishopping.DTOResponse.Manage.MProductListView(p.product_id, b.brand_name, p.name, p.price, SUM(pd.beforeCount), SUM(pd.sellCount)) " +
//            "FROM Product p " +
//            "LEFT JOIN p.brand_id b " +
//            "LEFT JOIN p.details pd " +
//            "WHERE p.name like concat('%',:name,'%') " +
//            "GROUP BY p.product_id " +
//            "ORDER BY SUM(pd.beforeCount) ,:order")
//    Optional<List<MProductListView>> MProductViewByNameOrderByAmount(Pageable pageable, String name, String order);
//
//    @Query("SELECT new com.i.minishopping.DTOResponse.Manage.MProductListView(p.product_id, b.brand_name, p.name, p.price, SUM(pd.beforeCount), SUM(pd.sellCount)) " +
//            "FROM Product p " +
//            "LEFT JOIN p.brand_id b " +
//            "LEFT JOIN p.details pd " +
//            "WHERE p.name like concat('%',:name,'%') " +
//            "GROUP BY p.product_id " +
//            "ORDER BY SUM(pd.sellCount) ,:order")
//    Optional<List<MProductListView>> MProductViewByNameOrderBySales(Pageable pageable, String name, String order);
}
