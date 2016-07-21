package io.khasang.stockmanager.controller;

import io.khasang.stockmanager.dao.impl.ProjectProductServiceImpl;
import io.khasang.stockmanager.dao.impl.ProjectServiceImpl;
import io.khasang.stockmanager.entity.Project;
import io.khasang.stockmanager.entity.ProjectProduct;
import io.khasang.stockmanager.service.ProductService;
import io.khasang.stockmanager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DeskController {

    @Autowired
    private ProjectServiceImpl projectServiceImpl;

    @Autowired
    private ProjectProductServiceImpl projectProductServiceImpl;

    @Autowired
    private ProductService productService;

    @Autowired
    private UserService userService;

    // general io.khasang.stockmanager.dao.desk
    @RequestMapping("/desk")
    public String desk(Model model) {
        Long userId = userService.getUserIdByLogin(SecurityContextHolder.getContext().getAuthentication().getName());
        model.addAttribute("projects", projectServiceImpl.getProjects());
        model.addAttribute("products", productService.getAllByUser(userId));
        model.addAttribute("users", projectServiceImpl.getUsers());
        model.addAttribute("projectsProducts", projectProductServiceImpl.getProjectProducts());
        return "desk/desk";
    }

    // project part
    @RequestMapping(value = "desk/addProject", method = RequestMethod.GET)
    public String addProject(@ModelAttribute Project project) {
        projectServiceImpl.addProject(project);
        return "redirect:/desk";
    }

    @RequestMapping("desk/deleteProject/{projectId}")
    public String deleteProject(@PathVariable("projectId") Long projectId) {
        projectServiceImpl.deleteProject(projectId);
        return "redirect:/desk";
    }

    @RequestMapping(value = "desk/updateStateProject", method = RequestMethod.GET)
    public String updateStateProject(@ModelAttribute Project project) {
        projectServiceImpl.updateStateProject(project);
        return "redirect:/desk";
    }

    // project_product part
    @RequestMapping(value = "desk/addProjectProduct", method = RequestMethod.GET)
    public String addProjectProduct(@ModelAttribute ProjectProduct projectProduct) {
        projectProductServiceImpl.addProjectProduct(projectProduct);
        return "redirect:/desk";
    }

    @RequestMapping("desk/deleteProjectProduct/{projectProductId}")
    public String deleteProjectProduct(@PathVariable("projectProductId") Long projectProductId) {
        projectProductServiceImpl.deleteProjectProduct(projectProductId);
        return "redirect:/desk";
    }
}
