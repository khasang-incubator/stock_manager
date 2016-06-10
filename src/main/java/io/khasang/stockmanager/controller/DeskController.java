package io.khasang.stockmanager.controller;

import io.khasang.stockmanager.dao.impl.ProjectProductService;
import io.khasang.stockmanager.dao.impl.ProjectService;
import io.khasang.stockmanager.entity.Project;
import io.khasang.stockmanager.entity.ProjectProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author ShtykovPavel
 */
@Controller
public class DeskController {

    @Autowired
    private ProjectService projectService;

    @Autowired
    private ProjectProductService projectProductService;

    // general io.khasang.stockmanager.dao.desk
    @RequestMapping("/desk")
    public String desk(Model model) {
        model.addAttribute("projects", projectService.getProjects());
        model.addAttribute("users", projectService.getUsers());
        model.addAttribute("projectsProducts", projectProductService.getProjectProducts());
        return "desk/desk";
    }

    // project part
    @RequestMapping(value = "desk/addProject", method = RequestMethod.GET)
    public String addProject(@ModelAttribute Project project) {
        projectService.addProject(project);
        return "redirect:/desk";
    }

    @RequestMapping("desk/deleteProject/{projectId}")
    public String deleteProject(@PathVariable("projectId") Long projectId) {
        projectService.deleteProject(projectId);
        return "redirect:/desk";
    }

    @RequestMapping(value = "desk/updateStateProject", method = RequestMethod.GET)
    public String updateStateProject(@ModelAttribute Project project) {
        projectService.updateStateProject(project);
        return "redirect:/desk";
    }

    // project_product part
    @RequestMapping(value = "desk/addProjectProduct", method = RequestMethod.GET)
    public String addProjectProduct(@ModelAttribute ProjectProduct projectProduct) {
        projectProductService.addProjectProduct(projectProduct);
        return "redirect:/desk";
    }

    @RequestMapping("desk/deleteProjectProduct/{projectProductId}")
    public String deleteProjectProduct(@PathVariable("projectProductId") Long projectProductId) {
        projectProductService.deleteProjectProduct(projectProductId);
        return "redirect:/desk";
    }
}
