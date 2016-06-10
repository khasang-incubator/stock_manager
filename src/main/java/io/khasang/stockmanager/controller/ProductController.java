package io.khasang.stockmanager.controller;


import io.khasang.stockmanager.entity.Product;
import io.khasang.stockmanager.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@Controller
public class ProductController {

    @Autowired
    ProductService productService;

    @RequestMapping("/products")
    public String listContacts(Map<String, Object> map) {
        map.put("product", new Product());
        map.put("productList", productService.getAll());
        return "product";
    }

    @RequestMapping("/delete/{productId}")
    public String deleteProduct(@PathVariable("productId") Integer productId) {
        productService.delete(productId);
        return "redirect:/products";
    }
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addProduct(@ModelAttribute("product") Product product,
                             BindingResult result) {
        productService.saveProduct(product);
        return "redirect:/products";
    }

}
