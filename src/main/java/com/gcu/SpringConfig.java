package com.gcu;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;

import com.gcu.business.OrdersBusinessInterface;
import com.gcu.business.OrderBusinessService;
import com.gcu.business.AnotherBusinessService;

@Configuration
public class SpringConfig {

	@Bean(name = "orderBusinessService", initMethod = "init", destroyMethod = "destroy")
	public OrdersBusinessInterface getOrdersBusiness() {
		return new OrderBusinessService();
	}

}