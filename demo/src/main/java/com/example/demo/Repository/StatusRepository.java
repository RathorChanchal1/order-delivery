package com.example.demo.Repository;

import com.example.demo.Model.Order;
import com.example.demo.Model.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StatusRepository extends JpaRepository<Status, Long> {
    Optional<Status> findByOrder(Order order);
}