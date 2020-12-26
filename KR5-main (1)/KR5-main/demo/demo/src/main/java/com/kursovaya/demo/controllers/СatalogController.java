package com.kursovaya.demo.controllers;

import com.kursovaya.demo.models.Product;
import com.kursovaya.demo.repo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.Optional;

@Controller
public class СatalogController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping ("/catalog")
    public String catalogMain (Model model) {
        Iterable<Product> products = productRepository.findAll();
        model.addAttribute("products", products);
        return "catalog";
    }

    @GetMapping ("/catalog/{product_id}")
    public String productDetails (@PathVariable (value = "product_id") long product_id, Model model) {
        Optional<Product> product = productRepository.findById(product_id);
        ArrayList<Product> res = new ArrayList<>();
        product.ifPresent(res::add);
        model.addAttribute("res", res);
        return "product-details";
    }

}
