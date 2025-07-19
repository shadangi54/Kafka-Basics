package com.example.common.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO {
	
	private String orderId;
	private String name;
	private int qty;
	private double price;
}