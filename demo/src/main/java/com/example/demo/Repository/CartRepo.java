package com.example.demo.Repository;

//import com.example.demo.Model.Cart;
import com.example.demo.Model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CartRepo extends JpaRepository<Cart, Long> {
//    Cart findByCartId(long cartId);
    Optional<Cart> findByCartId(long cartId);
//    Optional<Cart> findShoppingProdByCartId(Long cartId);



//    *****************
    void deleteByCartId(long cartId);
}
