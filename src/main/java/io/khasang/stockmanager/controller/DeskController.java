package io.khasang.stockmanager.controller;

import io.khasang.stockmanager.dao.impl.ProjectProductServiceImpl;
import io.khasang.stockmanager.dao.impl.ProjectServiceImpl;
import io.khasang.stockmanager.entity.Project;
import io.khasang.stockmanager.entity.ProjectProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DeskController {

    @Autowired
    private ProjectServiceImpl projectServiceImplImpl;

    @Autowired
    private ProjectProductServiceImpl projectProductServiceImplImpl;

    // general io.khasang.stockmanager.dao.desk
    @RequestMapping("/desk")
    public String desk(Model model) {
        model.addAttribute("projects", projectServiceImplImpl.getProjects());
        model.addAttribute("users", projectServiceImplImpl.getUsers());
        model.addAttribute("projectsProducts", projectProductServiceImplImpl.getProjectProducts());
        return "desk/desk";
    }

    // project part
    @RequestMapping(value = "desk/addProject", method = RequestMethod.GET)
    public String addProject(@ModelAttribute Project project) {
        projectServiceImplImpl.addProject(project);
        return "redirect:/desk";
    }

    @RequestMapping("desk/deleteProject/{projectId}")
    public String deleteProject(@PathVariable("projectId") Long projectId) {
        projectServiceImplImpl.deleteProject(projectId);
        return "redirect:/desk";
    }

    @RequestMapping(value = "desk/updateStateProject", method = RequestMethod.GET)
    public String updateStateProject(@ModelAttribute Project project) {
        projectServiceImplImpl.updateStateProject(project);
        return "redirect:/desk";
    }

    // project_product part
    @RequestMapping(value = "desk/addProjectProduct", method = RequestMethod.GET)
    public String addProjectProduct(@ModelAttribute ProjectProduct projectProduct) {
        projectProductServiceImplImpl.addProjectProduct(projectProduct);
        return "redirect:/desk";
    }

    @RequestMapping("desk/deleteProjectProduct/{projectProductId}")
    public String deleteProjectProduct(@PathVariable("projectProductId") Long projectProductId) {
        projectProductServiceImplImpl.deleteProjectProduct(projectProductId);
        return "redirect:/desk";
    }
}
