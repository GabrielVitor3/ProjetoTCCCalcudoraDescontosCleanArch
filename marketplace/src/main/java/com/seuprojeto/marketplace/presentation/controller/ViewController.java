package com.seuprojeto.marketplace.presentation.controller;

import com.seuprojeto.marketplace.domain.repository.ProdutoRepositorio;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {

    private final ProdutoRepositorio repository;

    public ViewController(ProdutoRepositorio repository) {
        this.repository = repository;
    }

    @GetMapping("/")
    public String index(Model model) {
        var products = repository.findAll();

        System.out.println("PRODUTOS: " + products);

        model.addAttribute("products", products);
        return "index";
    }
}