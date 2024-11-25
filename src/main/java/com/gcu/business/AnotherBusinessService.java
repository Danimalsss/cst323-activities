package com.gcu.business;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import com.gcu.model.OrderModel;

public class AnotherBusinessService implements OrdersBusinessInterface {

	@Override
	public void test() {
		// TODO Auto-generated method stub
		System.out.println("Hello from the AnotherOrdersBusinessService");
	}

	@Override
	public List<OrderModel> getOrders() {
		// Hard-coded list, replace with your data retrieval logic
		List<OrderModel> orders = new ArrayList<>();
		orders.add(new OrderModel(0L, "0000000001", "Product 1", 1.00f, 1));
		orders.add(new OrderModel(1L, "0000000002", "Product 2", 2.00f, 2));
		orders.add(new OrderModel(2L, "0000000003", "Product 3", 3.00f, 3));
		orders.add(new OrderModel(3L, "0000000004", "Product 4", 4.00f, 4));
		orders.add(new OrderModel(4L, "0000000005", "Product 5", 5.00f, 5));
		return orders;
	}

	@PostConstruct
	@Override
	public void init() {
		System.out.println("AnotherOrdersBusinessService initialized");
	}

	@PreDestroy
	@Override
	public void destroy() {
		System.out.println("AnotherOrdersBusinessService destroyed");
	}

}
