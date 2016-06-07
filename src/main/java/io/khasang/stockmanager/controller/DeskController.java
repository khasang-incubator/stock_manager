package io.khasang.stockmanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import io.khasang.stockmanager.dao.impl.ProjectService;
import io.khasang.stockmanager.entity.Project;
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
    ProjectService projectService;

    @RequestMapping("/desk")
    public String desk(Model model) {
        model.addAttribute("projects", projectService.getProjects());
        model.addAttribute("users", projectService.getUsers());
        return "desk/desk";
    }

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
}
