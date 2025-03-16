package com.example.Task.Manager.Controller;

import com.example.Task.Manager.Entity.Tasks;
import com.example.Task.Manager.Service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping("/task")
    public String fetchTask(Model model) {
        model.addAttribute("tasks", taskService.fetchAllTasks());
        model.addAttribute("task", new Tasks()); // Empty task for the form
        return "task";
    }

    @PostMapping("/addTask")
    public String addTask(@ModelAttribute Tasks task) { // Accept Tasks object from form
        taskService.saveTask(task); // Save the new task
        return "redirect:/task";
    }

    @PostMapping("/updateTask")
    public String updateTask(@ModelAttribute Tasks task) {
        taskService.updateTask(task);
        return "redirect:/task";
    }

    @PostMapping("/removeTask")
    public String removeTask(@RequestParam("id") Long id) {
        taskService.removeTask(id);
        return "redirect:/task";
    }
}