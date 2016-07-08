package io.khasang.stockmanager.controller;

import io.khasang.stockmanager.entity.ProductSalePlace;
import io.khasang.stockmanager.service.ProductSalePlaceService;
import io.khasang.stockmanager.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ProductSalePlaceController {
    private  Long productId;
    @Autowired
    ProductSalePlaceService productSalePlaceService;
    @Autowired
    ProductService productService;

    @RequestMapping("/productsaleplace/{productId}")
    public String productSalePlace(@PathVariable("productId") Long productId, Model model) {
        this.productId = productId;
        model.addAttribute("productSalePlaceList", productSalePlaceService.getAllByProductId(productId));
        model.addAttribute("productSalePlace", new ProductSalePlace());
        model.addAttribute("productName",productService.getById(productId).getName());
        return "productsaleplaces";
    }
    @RequestMapping(value = "/productsaleplace/add", method = RequestMethod.POST)
    public String addProduct(@ModelAttribute("productSalePlace") ProductSalePlace productSalePlace,
                             BindingResult result) {
        productSalePlace.setProductId(productId);
        productSalePlaceService.saveProductSalePlace(productSalePlace);
        return "redirect:/productsaleplace/"+ productId;
    }

    @RequestMapping("/productsaleplace/delete/{id}")
    public String deleteProduct(@PathVariable("id") Long id) {
        productSalePlaceService.delete(id);
        return "redirect:/productsaleplace/"+ productId;
    }


}
