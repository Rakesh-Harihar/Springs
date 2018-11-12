package com.valtech.trainingprocess.training.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.valtech.trainingprocess.common.exception.TrainingProcessException;
import com.valtech.trainingprocess.common.util.CommonUtil;
import com.valtech.trainingprocess.trainer.model.Trainer;
import com.valtech.trainingprocess.trainer.service.TrainerService;
import com.valtech.trainingprocess.training.model.Category;
import com.valtech.trainingprocess.training.model.Status;
import com.valtech.trainingprocess.training.model.Trainee;
import com.valtech.trainingprocess.training.model.Training;
import com.valtech.trainingprocess.training.service.TrainingService;
import com.valtech.trainingprocess.vendor.model.Vendor;
import com.valtech.trainingprocess.vendor.service.VendorService;

@Controller
public class TrainingController {

	@Autowired
	private TrainingService trainingService;

	@Autowired
	private VendorService vendorService;

	@Autowired
	private TrainerService trainerService;

	@RequestMapping("/trainingRequest")
	public ModelAndView trainingRequest() {

		ModelAndView modelAndView = new ModelAndView("training_request");
		List<Category> categoryList = null;
		try {
			categoryList = trainingService.getCategoryList();
		} catch (TrainingProcessException e) {

			modelAndView.addObject("errorMessage", e.getMessage());
			return modelAndView;
		}
		modelAndView.addObject("training", new Training());
		modelAndView.addObject("categoryList", categoryList);
		return modelAndView;
	}

	@RequestMapping("/submitRequest")
	public ModelAndView submitTrainingRequest(@Valid @ModelAttribute("training") Training training,
			BindingResult result, HttpSession httpSession, final @RequestParam CommonsMultipartFile[] trainingToc) {

		ModelAndView modelAndView = null;
		List<Training> trainingDetail = null;
		String currentUser = null;
		List<Category> categoryList = null;
		
		for (CommonsMultipartFile file : trainingToc) {
			training.setTrainingFileName(file.getOriginalFilename());
			training.setTrainingToc(file.getBytes());
		}
		
		currentUser = (String) httpSession.getAttribute("user");
		training.setCreatedBy(currentUser);
		training.setStatusId(CommonUtil.defaultStatus);
		try {

			trainingService.saveTrainingRequest(training);

			trainingDetail = trainingService.getTrainingRequest(currentUser);
		} catch (TrainingProcessException e) {
			
			try {
				categoryList = trainingService.getCategoryList();
			} catch (TrainingProcessException f) {

				
			}
			modelAndView = new ModelAndView("training_request");
			modelAndView.addObject("categoryList", categoryList);
			modelAndView.addObject("errorMessage", e.getMessage());
			return modelAndView;
		}
		modelAndView = new ModelAndView("training_request_manager", "trainingDetail", trainingDetail);
		return modelAndView;
	}

	@RequestMapping("/viewTrainingRequest")
	public ModelAndView viewTrainingRequest(HttpSession httpSession) {
		String currentUser = (String) httpSession.getAttribute("user");

		ModelAndView modelAndView = new ModelAndView("training_request_manager");
		List<Training> trainingDetail = null;
		try {
			trainingDetail = trainingService.getTrainingRequest(currentUser);
		} catch (TrainingProcessException e) {
			modelAndView.addObject("errorMessage", e.getMessage());
		}
		modelAndView.addObject("trainingDetail", trainingDetail);
		return modelAndView;
	}

	@RequestMapping("/viewTrainingRequestAll")
	public ModelAndView viewTrainingRequestAll() {

		List<Training> trainingList = null;
		ModelAndView modelAndView = new ModelAndView("training_request_admin");
		try {
			trainingList = trainingService.getTrainingRequestAll();
		} catch (TrainingProcessException e) {
			modelAndView.addObject("errorMessage", e.getMessage());
		}
		modelAndView.addObject("trainingList", trainingList);
		return modelAndView;
	}

	@RequestMapping("/trainingDetails")
	public ModelAndView viewTrainigDetails() {

		ModelAndView modelAndView = new ModelAndView("training_details");
		List<Training> trainingDetails = null;
		try {
			trainingDetails = trainingService.getTrainingDetails();
		} catch (TrainingProcessException e) {
			modelAndView.addObject("errorMessage", e.getMessage());
		}
		
		modelAndView.addObject("trainingDetails", trainingDetails);
		return modelAndView;
	}

	@RequestMapping("/assignTrainer")
	public ModelAndView assignTrainer(@ModelAttribute("trainingDetail") Training trainingDetail,
			@RequestParam("trainingId") int trainingId) {
		try {
			List<Vendor> vendorList = vendorService.getVendorDetails();
			List<Status> statusList = trainingService.getAllStatus();
			ModelAndView obj = new ModelAndView("assign_trainer");
			obj.addObject("trainingDetail", new Training());
			obj.addObject("trainingId", trainingId);
			obj.addObject("vendorList", vendorList);
			obj.addObject("statusList", statusList);
			return obj;
		} catch (TrainingProcessException e) {
			ModelAndView mav = new ModelAndView("vendor_registration");
			mav.addObject("errorMessage", e.getMessage());
			return mav;
		}
	}

	@RequestMapping("/updateTraining")

	public ModelAndView statusUpdated(@ModelAttribute("trainingDetail") Training training,
			@RequestParam("trainingId") int trainingId, HttpSession httpSession) {

		ModelAndView modelAndView = new ModelAndView("training_request_admin");

		String currentUser = (String) httpSession.getAttribute("user");
		training.setUpdatedBy(currentUser);

		List<Training> trainingDetail;
		try {

			trainingService.updateStatus(training);
			trainingDetail = trainingService.getTrainingRequestAll();
		} catch (TrainingProcessException e) {

			modelAndView.addObject("assign_trainer");
			modelAndView.addObject("errorMessage", e.getMessage());
			return modelAndView;

		}
		modelAndView.addObject("trainingList", trainingDetail);
		return modelAndView;
	}

	@RequestMapping("/viewTrainingDetials")
	public ModelAndView viewTrainingDetails(@RequestParam("trainingId") int trainingId) {

		Training training = null;
		List<Trainee> trainees = null;
		ModelAndView modelAndView = new ModelAndView("view_training_details");

		try {
			training = trainingService.getTrainingDetail(trainingId);
			trainees = trainingService.getTraineeList(trainingId);

		} catch (TrainingProcessException e) {
			modelAndView.addObject("errorMessage", e.getMessage());
			return modelAndView;
		}
		modelAndView.addObject("training", training);
		modelAndView.addObject("trainees", trainees);

		return modelAndView;
	}

	@RequestMapping("/traineeDetails")
	public ModelAndView traineeDetails(@ModelAttribute("trainee") Trainee trainee,
			@RequestParam("trainingId") int trainingId) {
		ModelAndView modelAndView = new ModelAndView("trainee_details");

		List<Trainee> trainees;
		try {
			trainees = trainingService.getTraineeList(trainingId);
		} catch (TrainingProcessException e) {

			modelAndView.addObject("errorMessage", e.getMessage());
			return modelAndView;
		}
		modelAndView.addObject("trainingId", trainingId);
		modelAndView.addObject("trainees", trainees);
		return modelAndView;
	}

	@RequestMapping("/submitTrainee")
	public ModelAndView submitTrainee(@ModelAttribute("trainee") Trainee trainee,
			@RequestParam("trainingId") int trainingId) {
		ModelAndView modelAndView = new ModelAndView("trainee_details");
		trainee.setTrainingId(trainingId);

		List<Trainee> trainees = null;
		try {
			trainingService.saveTraineeDetail(trainee);
			trainees = trainingService.getTraineeList(trainingId);
		} catch (TrainingProcessException e) {
			modelAndView.addObject("errorMessage", e.getMessage());
			return modelAndView;
		}
		modelAndView.addObject("trainingId", trainingId);
		modelAndView.addObject("trainees", trainees);
		modelAndView.addObject("trainee", new Trainee());
		return modelAndView;
	}

	@RequestMapping(value = "/getvendorstrainer", headers = "Accept=*/*", produces = { "application/json" })
	public @ResponseBody String getvendorstrainer(@RequestParam("vendorId") int vendorId, Model model) {
		try {
			List<Trainer> trainerList = trainerService.getTrainerList(vendorId);
			return new ObjectMapper().writeValueAsString(trainerList);
		} catch (TrainingProcessException e) {
			return null;
		} catch (JsonProcessingException e) {
			return null;
		}
	}

}
