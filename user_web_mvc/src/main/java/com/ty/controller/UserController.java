package com.ty.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ty.dao.UserDao;
import com.ty.dto.User;

@Controller
public class UserController {
	@Autowired
	UserDao dao;

	@RequestMapping("/load")
	public ModelAndView loadUser() {
		ModelAndView view = new ModelAndView();
		view.addObject("user", new User());
		view.setViewName("saveUser.jsp");
		return view;
	}

	@RequestMapping("/save")
	public ModelAndView SaveUser(@ModelAttribute User user,ModelAndView view) {
		 user=dao.saveUser(user);
		 view.setViewName("view.jsp");
		 view.addObject(user);
		 return view;
	}
}
