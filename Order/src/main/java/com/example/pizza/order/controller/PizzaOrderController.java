package com.example.pizza.order.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.pizza.order.exception.PizzaHutOrderNotFoundException;
import com.example.pizza.order.model.PizzaHut;
import com.example.pizza.order.service.PizzaService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


@RestController
@RequestMapping("/v1/order")
public class PizzaOrderController {

	@Autowired
	private PizzaService pizzaService;

	@Autowired
	private ObjectMapper objectMapper;

	@GetMapping("/{orderId}")
	public ResponseEntity<PizzaHut> getPizzaHutDetails(@PathVariable("orderId") Long orderId)
			throws PizzaHutOrderNotFoundException {

		PizzaHut pizzaHut = pizzaService.findPizzaHutByOrderId(orderId);

		return new ResponseEntity<PizzaHut>(pizzaHut, null, HttpStatus.OK);

	}

	@GetMapping("/orderName/{orderName}")
	public ResponseEntity<List<PizzaHut>> getPizzaHutDetailsByOrderName(@PathVariable("orderName") String orderName)
			throws PizzaHutOrderNotFoundException {

		List<PizzaHut> pizza = pizzaService.findPizzaHutByOrderName(orderName);

		return new ResponseEntity<List<PizzaHut>>(pizza, null, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<String> insertPizzaHutDetails(@RequestBody PizzaHut pizzaHut) throws JsonProcessingException {

		PizzaHut pizzaHutSaved = null;
		pizzaHutSaved= pizzaService.savePizzaHut(pizzaHut);
		
	    System.out.println("saved order information : "+objectMapper.writeValueAsString(pizzaHutSaved));


		return new ResponseEntity<String>("Record Saved Successfully", new HttpHeaders(),
				HttpStatus.OK);

	}
}
