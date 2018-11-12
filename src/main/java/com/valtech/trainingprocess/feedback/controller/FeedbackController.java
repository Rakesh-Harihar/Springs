package com.valtech.trainingprocess.feedback.controller;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.valtech.trainingprocess.feedback.model.Feedback;
import com.valtech.trainingprocess.feedback.service.FeedbackService;

@Controller
public class FeedbackController {


	@Autowired
	private FeedbackService feedbackservice;

	

	@RequestMapping("/feedbackRegistration")
	public ModelAndView getFeedback() {
		

		ModelAndView obj = new ModelAndView("trainee_feedback", "feedback", new Feedback());
		return obj;
	}

	@RequestMapping("/submitFeedback")
	public ModelAndView saveFeedback(@ModelAttribute("feedback") Feedback feedback, BindingResult result,
			Model model, HttpServletRequest request, HttpServletResponse response) {
		

		if (result.hasErrors()) {
			ModelAndView mav = new ModelAndView("trainee_feedback");
			return mav;
		}
	
		boolean success = feedbackservice.saveFeedbackDetail(feedback);
		ModelAndView mav = new ModelAndView("success");
		
		return mav;
	}
	
	}

