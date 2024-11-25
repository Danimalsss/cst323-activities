package com.gcu.business;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;

import com.gcu.data.DataAccessInterface;
import com.gcu.model.OrderModel;

public class OrderBusinessService implements OrdersBusinessInterface {

	@Autowired
	private DataAccessInterface<OrderModel> service;

	@Override
	public void test() {
		// TODO Auto-generated method stub
		System.out.println("Hello from the OrdersBusinessService");

	}

	@Override
	public List<OrderModel> getOrders() {
		return service.findAll();

	}

	@jakarta.annotation.PostConstruct
	@Override
	public void init() {
		System.out.println("OrdersBusinessService initialized");
	}

	@jakarta.annotation.PreDestroy
	@Override
	public void destroy() {
		System.out.println("OrdersBusinessService destroyed");
	}
}
