
package com.example.demo.Controller;

import com.example.demo.Model.Cart;
import com.example.demo.Service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8083")
//@RestController
//@RequestMapping("/cartProducts")
//public class CartController {
//
//    @Autowired
//    private CartService cartService;
//
//    @GetMapping("/cart")
//    public ResponseEntity<List<Cart>> findCartProduct() {
//        try {
//            List<Cart> cartList = cartService.findCartProduct();
//
//            if (cartList.isEmpty()) {
//                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//            }
//
//            return new ResponseEntity<>(cartList, HttpStatus.OK);
//        } catch (Exception e) {
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//}
//http://localhost:8083/cartProducts/{cartId}/processPayment
@RestController
@RequestMapping("/cartProducts")
public class CartController {

    @Autowired
    private CartService cartService;

    @GetMapping("/cart")
    public ResponseEntity<Cart> addShopNotShopProductsToCart() {
        Cart cart = new Cart();
        cart = cartService.addShoppingProductsToCart(cart);

        if (cart.getShoppingProducts().isEmpty()) {
            // Return 404 if no products were found with shopNotShop = true
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            // Return 200 OK with the cart object
            return new ResponseEntity<>(cart, HttpStatus.OK);
        }
    }
    //modifications*********************************


    // Example of processing payment for a cart
    @PostMapping("/{cartId}/processPayment")
//    public ResponseEntity<Void> processPayment(@PathVariable Long cartId) {
//        try {
//            cartService.processPayment(cartId);
//            return ResponseEntity.ok().build();
//        } catch (RuntimeException e) {
//            // Log the exception and return a meaningful error response
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }

    public ResponseEntity<String> processPayment(@PathVariable Long cartId) {
        try {
            cartService.processPayment(cartId);
            return ResponseEntity.ok("Cart products have been successfully shifted to order history.");
        } catch (RuntimeException e) {
            // Log the exception and return a meaningful error response
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to shift cart products to order history.");
        }
    }






}


// Create a new cart
//    @PostMapping
//    public ResponseEntity<Cart> createCart(@RequestBody Cart cart) {
//        Cart createdCart = cartService.createCart(cart);
//        return ResponseEntity.ok(createdCart);
//    }

// Get cart by ID
//    @GetMapping("/{cartId}")
//    public ResponseEntity<Cart> getCartById(@PathVariable Long cartId) {
//        Cart cart = cartService.getCartById(cartId);
//        return ResponseEntity.ok(cart);
//    }
//
//    // Update a cart
//    @PutMapping("/{cartId}")
//    public ResponseEntity<Cart> updateCart(@PathVariable Long cartId, @RequestBody Cart cartDetails) {
//        Cart updatedCart = cartService.updateCart(cartId, cartDetails);
//        return ResponseEntity.ok(updatedCart);
//    }

// Delete a cart
//    @DeleteMapping("/{cartId}")
//    public ResponseEntity<Void> deleteCart(@PathVariable Long cartId) {
//        cartService.deleteCart(cartId);
//        return ResponseEntity.noContent().build();
//    }
