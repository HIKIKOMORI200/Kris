package com.kursovaya.demo.controllers;



import com.kursovaya.demo.models.Purchase;
import com.kursovaya.demo.models.ShoppingCart;

import com.kursovaya.demo.repo.PurechaseRepository;
import com.kursovaya.demo.repo.ShoppingCartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class MainController {

    @Autowired
    private ShoppingCartRepository shoppingCartRepository;

    @Autowired
    private PurechaseRepository purechaseRepository;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("title", "Мятное небо");
        return "home";
    }

    @GetMapping("/shoppingcart")
    public String shoppingCart(Model model) {

        Iterable<ShoppingCart> shoppingCarts = shoppingCartRepository.findAll();
        model.addAttribute("shoppingCarts", shoppingCarts);

        Iterable<Purchase> purchases = purechaseRepository.findAll();
        model.addAttribute("purchases", purchases);

        return "shopping-cart";
    }

    @GetMapping("/about")
    public String about(Model model) {

        return "about";
    }

    @PostMapping("/shoppingcart")
    public String orderAdd (@RequestParam String firstName, @RequestParam String lastName, @RequestParam String email, @RequestParam String address, @RequestParam String zip, @RequestParam String cc_name, @RequestParam String cc_number, @RequestParam String cc_expiration, @RequestParam String cc_cvv, Model model) {
        Purchase purchase = new Purchase(email,firstName,lastName, address, zip, cc_name, cc_number, cc_cvv, cc_expiration);
        purechaseRepository.save(purchase);
        return "shopping-cart";
    }


}