package com.example.demo.Repository;

import com.example.demo.Model.Customer;
import com.example.demo.Model.Shopping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
//public interface ShoppingRepo extends JpaRepository<Shopping, Long> {
//    public List<Shopping> findByproductId(long id);
//    public List<Shopping> findByshopNotShop(boolean check);
//
//}

public interface ShoppingRepo extends JpaRepository<Shopping, Long> {
    List<Shopping> findByProductId(long id);
    List<Shopping> findByShopNotShop(boolean check);

    List<Shopping> findByShopNotShopTrue();

}