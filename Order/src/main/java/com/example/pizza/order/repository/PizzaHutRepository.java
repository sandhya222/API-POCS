package com.example.pizza.order.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.pizza.order.model.PizzaHut;


@Repository
public interface PizzaHutRepository extends JpaRepository<PizzaHut, Long> {

	PizzaHut findByOrderId(Long orderId);

   List<PizzaHut> findByOrderName(String orderName);

}

