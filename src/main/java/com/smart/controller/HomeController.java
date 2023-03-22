package com.smart.controller;

import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.smart.dao.UserRepository;
import com.smart.entities.UserEntity;
import com.smart.helper.Message;
@Controller
public class HomeController {
	
	@Autowired
	private UserRepository userRepository;
	
	
	@GetMapping("/home")
	public String Home(Model model) {
		model.addAttribute("title","Home-smart contact manager");
		return "Home";
	}
	
	@GetMapping("/about")
	public String about(Model model) {
		model.addAttribute("title","About-smart contact manager");
		return "about";
	}
	
	@GetMapping("/signup")
	public String signup(Model model) {
		model.addAttribute("title","Signup-smart contact manager");
		model.addAttribute("userEntity", new UserEntity());
		return "signup";
	}
	
	@GetMapping("/login")
	public String login(Model model) {
		model.addAttribute("title","login-smart contact manager");
		return "login";
	}
	
	@PostMapping("/do_register")
	public String registerUser(@ModelAttribute("userEntity") UserEntity userEntity ,
			@RequestParam(value="agreement", defaultValue="false") boolean agreement, Model model,HttpSession session){
		
		try {
			if(!agreement) {
				System.out.println("you have not agreed the terms and condition");
				throw new Exception("you have not agreed the terms and condition");
			}
			userEntity.setRole("ROLE_USER");
			userEntity.setEnabled(true);
			userEntity.setImageUrl("default.png");
			
			System.out.println("agreement" + agreement);
			System.out.println("userEntity"+ userEntity);
			
			UserEntity result = this.userRepository.save(userEntity);
			model.addAttribute("userEntity",new  UserEntity());
			session.setAttribute("message", new Message("successfully registerd","alert-success"));
			return "signup";
			
		
			
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("userEntity", userEntity);
			session.setAttribute("message", new Message("something went wrong !! you have not agreed terms and conditions !! ","alert-danger"));
			return "signup";
		}
		
		
	}
	}
