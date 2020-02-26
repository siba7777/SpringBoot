package com.example.springcrud.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.springcrud.domain.User;
import com.example.springcrud.service.UserService;

@Controller
@RequestMapping("users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("users", userService.findAll());
        return "users/index";
    }

    @GetMapping(value = "new")
    public String newUser(Model model) {
        model.addAttribute("user", new User());
        return "users/new";
    }

    @GetMapping(value = "{id}/edit")
	public String edit(@PathVariable Long id, Model model) {
		Optional<User> user = userService.findOne(id);
		user.ifPresent(u -> model.addAttribute("user", u));
		return "users/edit";
	}

    @GetMapping(value = "{id}")
    public String show(@PathVariable Long id, Model model) {
    	Optional<User> user = userService.findOne(id);
    	user.ifPresent(u -> model.addAttribute("user", u));
        return "users/show";
    }

    @PostMapping
    public String create(@ModelAttribute User user) {
        userService.save(user);
        return "redirect:/users";
    }

    @PutMapping(value = "{id}")
    public String update(@PathVariable Long id, @ModelAttribute User user) {
        user.setId(id);
        userService.save(user);
        return "redirect:/users";
    }

    @DeleteMapping(value = "{id}")
    public String destroy(@PathVariable Long id) {
        userService.delete(id);
        return "redirect:/users";
    }
}
