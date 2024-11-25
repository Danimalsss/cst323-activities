package com.gcu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.gcu.business.OrdersBusinessInterface;
import com.gcu.business.SecurityBusinessServer;
import com.gcu.model.LoginModel;
import com.gcu.model.OrderModel;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/login")
public class LoginController {

	@Autowired
	private OrdersBusinessInterface service;

	@Autowired
	private SecurityBusinessServer security;



	@PostMapping("/doLogin")
	public String doLogin(@Valid LoginModel loginModel, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("title", "Login Form");
			return "login";
		}

		// Call the test() method
		service.test();

		security.authenticate("user", "pass");

		List<OrderModel> orders = service.getOrders();
		model.addAttribute("title", "My Orders");
		model.addAttribute("orders", orders);

		return "orders";
	}
}
