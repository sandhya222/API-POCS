package com.example.pizza.order.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.pizza.order.exception.PizzaHutOrderNotFoundException;
import com.example.pizza.order.model.PizzaHut;
import com.example.pizza.order.repository.PizzaHutRepository;

@Service
public class PizzaService {
	
	@Autowired
	private PizzaHutRepository pizzaHutRepository;

	public PizzaHut findPizzaHutByOrderId(Long orderId) throws PizzaHutOrderNotFoundException {
		// TODO Auto-generated method stub
		
		
		PizzaHut pizzaHut= pizzaHutRepository.findByOrderId(orderId);
		
		if(pizzaHut == null) {
			
			throw new PizzaHutOrderNotFoundException("no record found for order number : " +orderId);

			
		}
		return pizzaHut;
	}
	
	public PizzaHut savePizzaHut(PizzaHut pizzaHut) {
		
		return pizzaHutRepository.save(pizzaHut);
		
	}
	public List<PizzaHut> findPizzaHutByOrderName(String orderName){
		
		return pizzaHutRepository.findByOrderName(orderName);
		
	}
	
	

}
