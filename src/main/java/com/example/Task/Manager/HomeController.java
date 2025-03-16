package com.example.Task.Manager;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    public String home() {
        return "redirect:/task";  // Or redirect to another page like "/dashboard"
    }
}
