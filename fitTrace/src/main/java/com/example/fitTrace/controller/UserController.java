package com.example.fitTrace.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.fitTrace.ServiceImpl.UserServiceImpl;
import com.example.fitTrace.entity.User;
import com.example.fitTrace.repository.UserRepository;
@RestController
public class UserController {
	@Autowired
	UserServiceImpl userservice;
   @GetMapping("/public/login/{name}/{password}")
   public User logInUser(@PathVariable String name,@PathVariable String password)
   {
	   return userservice.login(name, password);
   }
   @PostMapping("/public/register")
   public User Register(@RequestBody User user)
   {
	   return  userservice.register(user);
}
   @GetMapping("/admin/getAllUsers")
   public List<User> getusers() {
	   return userservice.getusers();
          }
   @GetMapping("/public/get/{id}")
   public User getUserById(@PathVariable Long id) {
	     return userservice.getUserById(id);
    }
   @PutMapping("/public/update")
   public User updateUser(@RequestBody User user) {
	   return userservice.updateUser(user);
   }
   @GetMapping("/public/csrf-token")
   public CsrfToken getCsrfToken(HttpServletRequest request) {
       // Spring Security automatically provides the CsrfToken as a request attribute
	   System.out.println(request.getSession().getId());
       return (CsrfToken) request.getAttribute(CsrfToken.class.getName());
   }
  
}