package com.gcu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gcu.business.OrdersBusinessInterface;
import com.gcu.business.SecurityBusinessServer;
import com.gcu.model.LoginModel;
import com.gcu.model.OrderModel;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private OrdersBusinessInterface service;

    @Autowired
    private SecurityBusinessServer security;

    @GetMapping("/")
    public String display(Model model) {
        model.addAttribute("title", "Login Form");
        LoginModel login = new LoginModel("User", "Pass");
        model.addAttribute("loginModel", login);
        return "login"; // This returns the login view
    }

    @PostMapping("/doLogin")
    public String doLogin(@Valid LoginModel loginModel, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("title", "Login Form");
            return "login"; // Return to the login page with errors
        }

        // Call the test() method from OrdersBusinessInterface
        service.test();

        // Authenticate using SecurityBusinessServer
        security.authenticate(loginModel.getUsername(), loginModel.getPassword());

        // Fetch orders after successful authentication
        List<OrderModel> orders = service.getOrders();
        model.addAttribute("title", "My Orders");
        model.addAttribute("orders", orders);

        return "orders"; // Redirect to orders view after successful login
    }
}