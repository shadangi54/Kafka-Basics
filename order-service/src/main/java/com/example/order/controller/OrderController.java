package com.example.order.controller;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.common.DTO.OrderDTO;
import com.example.common.DTO.OrderEvent;
import com.example.order.kafka.OrderProducer;

@RestController
@RequestMapping("/order")
public class OrderController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(OrderController.class);
	
	private OrderProducer orderProducer;
	
	@GetMapping("/")
	public String hello() {
		return "Hello from Order Service";
	}
	
	@PostMapping("/placeOrder")
	public String createOrder(@RequestBody OrderDTO order) {
		try {
			LOGGER.info("Inside createOrder method");
			order.setOrderId(UUID.randomUUID().toString());
			
			OrderEvent event = new OrderEvent();
			event.setOrder(order);
			event.setMessage("Order status is pending");
			event.setStatus("PENDING");
			
			orderProducer.sendMessage(event);
			
			return "Order placed successfully with Order ID #"+order.getOrderId();
		}catch(Exception e) {
			return "Failed to place order";
		}
	}



	public OrderController(OrderProducer orderProducer) {
		super();
		this.orderProducer = orderProducer;
	}
}
