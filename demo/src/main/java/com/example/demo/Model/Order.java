package com.example.demo.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Entity
@Table(name = "orders")  // Consider renaming to avoid conflict with SQL keywords

public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private long orderId;

    @OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
//    @OneToMany
    @JoinColumn(name = "order_cart", referencedColumnName = "order_id")
    private List<Cart> orderCart;

    // Getters, Setters, Constructors, toString()


}


