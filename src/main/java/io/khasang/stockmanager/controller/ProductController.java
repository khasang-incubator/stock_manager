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
    public String listProducts(Map<String, Object> map) {
        map.put("product", new Product());
        map.put("productList", productService.getAll());
        return "product";
    }

    @RequestMapping("products/delete/{productId}")
    public String deleteProduct(@PathVariable("productId") Long productId) {
        productService.delete(productId);
        return "redirect:/products";
    }
    @RequestMapping(value = "products/add", method = RequestMethod.POST)
    public String addProduct(@ModelAttribute("product") Product product,
                             BindingResult result) {
        productService.saveProduct(product);
        return "redirect:/products";
    }

}
