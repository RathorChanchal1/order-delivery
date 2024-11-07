package com.example.demo.Controller;

import com.example.demo.Model.Shopping;
import com.example.demo.Service.ShoppingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:8083")
@RestController
@RequestMapping("/ShoppingProducts")
public class ShoppingController {

    @Autowired
    private ShoppingService shoppingService;

    @GetMapping("/products")
    public ResponseEntity<List<Shopping>> getAllProducts(@RequestParam(required = false) Long id) {
        try {
            List<Shopping> shopings = shoppingService.getAllProducts(id);

            if (shopings.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(shopings, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<Shopping> getProductById(@PathVariable("id") long id) {
        Optional<Shopping> shopingData = shoppingService.getProductById(id);

        if (shopingData.isPresent()) {
            return new ResponseEntity<>(shopingData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/products")
    public ResponseEntity<Shopping> createProduct(@RequestBody Shopping customer) {
        try {
            Shopping _shopping = shoppingService.createProduct(customer);
            return new ResponseEntity<>(_shopping, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }




    //16 sept update
    @PutMapping("/products/{id}")
    public ResponseEntity<Shopping> updateProduct(@PathVariable long id, @RequestBody Shopping productUpdate){
        productUpdate.setProductId(id);
        return ResponseEntity.ok().body(this.shoppingService.updateProduct(productUpdate));
    }

//    @GetMapping("/cartProducts")
//    public ResponseEntity<List<Shopping>> findCartProduct() {
//        try {
//            List<Shopping> products = shoppingService.findBycartProduct();
//
//
//            if (products.isEmpty()) {
//                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//            }
//            return new ResponseEntity<>(products, HttpStatus.OK);
//        } catch (Exception e) {
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }

    // You can also uncomment and add the Cart transfer logic here using the shoppingService.transferToCart(productId) method.
}
