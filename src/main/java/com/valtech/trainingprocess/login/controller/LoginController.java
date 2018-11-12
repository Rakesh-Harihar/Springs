package com.valtech.trainingprocess.login.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.valtech.trainingprocess.common.exception.TrainingProcessException;
import com.valtech.trainingprocess.login.model.Login;
import com.valtech.trainingprocess.login.service.LoginService;

@Controller
public class LoginController {

	@Autowired
	LoginService loginService;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView showLogin(HttpServletRequest request, HttpServletResponse response) {

		ModelAndView mav = new ModelAndView("login");
		mav.addObject("login", new Login());

		return mav;
	}

	@RequestMapping("/loginProcess")
	public ModelAndView validateUser(@Valid @ModelAttribute("login") Login login, BindingResult result,
			HttpSession httpSession) {
		ModelAndView mavLogin = new ModelAndView("login");
		ModelAndView trainingHome = new ModelAndView("training_home");

		Login loginDetail = null;
		try {
			if (result.hasErrors()) {
				return mavLogin;
			}
			loginDetail = loginService.validateUser(login);
			httpSession.setAttribute("role", loginDetail.getRole());
			httpSession.setAttribute("user", loginDetail.getUserName());

		} catch (TrainingProcessException e) {
			mavLogin.addObject("errorMessage", e.getMessage());
			return mavLogin;
		}

		trainingHome.addObject("role", loginDetail.getRole());
		trainingHome.addObject("user", loginDetail.getUserName());
		return trainingHome;
	}
	
	@RequestMapping("/logout")
	public ModelAndView logout(HttpSession httpSession, HttpServletRequest request){
		httpSession = request.getSession();
		httpSession.invalidate();
		ModelAndView mav = new ModelAndView("login");
		mav.addObject("login", new Login());
		return mav;
	}

}