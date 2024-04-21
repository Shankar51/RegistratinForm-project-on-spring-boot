package com.app.controller;

//import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;

import com.app.entity.User;
import com.app.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	
	@Autowired
	private UserService service;
	
    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "registration";
    }

    @PostMapping("/register")
    public String processRegistration(@ModelAttribute("user") User user, Model model) {
        if (!user.getPassword().equals(user.getCpassword())) {
            model.addAttribute("errorMessage", "Password and Confirm Password do not match");
            return "registration";
        }

        service.registerUser(user);
        model.addAttribute("successMessage", "Registration done successfully!");
        return "redirect:/registration-success";
    }
    
    
    //    this for json data
	/*
	 * @GetMapping("/registration-success") public String showRegistrationSuccess()
	 * { return "registration-success"; }
	 * 
	 * @GetMapping("/readAll") public List<User> getAllUser(){ List<User> allUser =
	 * service.getAllUser(); return allUser;
	 * 
	 * }
	 * 
	 * @PostMapping() public void createPatient(@RequestBody User user) {
	 * service.createPatient(user);
	 * 
	 * }
	 */


}
