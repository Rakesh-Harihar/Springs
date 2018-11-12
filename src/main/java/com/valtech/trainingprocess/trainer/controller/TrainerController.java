package com.valtech.trainingprocess.trainer.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.valtech.trainingprocess.common.exception.TrainingProcessException;
import com.valtech.trainingprocess.trainer.model.Trainer;
import com.valtech.trainingprocess.trainer.service.TrainerService;
import com.valtech.trainingprocess.vendor.model.Vendor;
import com.valtech.trainingprocess.vendor.service.VendorService;

@Controller
public class TrainerController {
	@Autowired
	private TrainerService trainerService;

	@Autowired
	private VendorService vendorService;

	@RequestMapping("/trainerRegistration")
	public ModelAndView getVendorDetail() {
		List<Vendor> vendorList = null;
		ModelAndView mav = null;
		try {
			vendorList = vendorService.getVendorDetails();
		} catch (TrainingProcessException e) {
			mav = new ModelAndView("trainer_registration");
			mav.addObject("errorMessage", e.getMessage());
			return mav;
		}
		mav = new ModelAndView("trainer_registration");
		mav.addObject("vendorList", vendorList);
		mav.addObject("trainer", new Trainer());
		return mav;
	}

	@RequestMapping("/submitTrainer")
	public ModelAndView saveTrainer(@ModelAttribute("trainer") Trainer trainer, BindingResult result,
			HttpSession httpSession, final @RequestParam CommonsMultipartFile[] toc,
			final @RequestParam CommonsMultipartFile[] profile) {

		ModelAndView mav = null;

		try {

			for (CommonsMultipartFile file : toc) {
				trainer.setTocFileName(file.getOriginalFilename());
				trainer.setToc(file.getBytes());
			}

			for (CommonsMultipartFile file : profile) {
				trainer.setProfileFileName(file.getOriginalFilename());
				trainer.setProfile(file.getBytes());
			}
			if (trainer.getTrainerId() == 0) {

				trainer.setCreatedBy((String) httpSession.getAttribute("user"));
				trainerService.saveTrainerDetail(trainer);
				mav = new ModelAndView("view_vendor");
				mav.addObject("vendorList", vendorService.getVendorDetails());
			} else {
				trainer.setModifiedBy((String) httpSession.getAttribute("user"));
				trainerService.updateTrainerDetail(trainer);
				mav = new ModelAndView("view_trainer");
				mav.addObject("vendor", vendorService.getVendor(trainer.getVendorId()));
				mav.addObject("trainerList", trainerService.getTrainerList(trainer.getVendorId()));
			}
			

		} catch (TrainingProcessException e) {
			mav = new ModelAndView("trainer_registration");
			mav.addObject("errorMessage", e.getMessage());
			return mav;
		}
		return mav;
	}

	@RequestMapping("/viewTrainer")
	public ModelAndView getTrainerDetails(@RequestParam("trainerId") int trainerId) {

		Trainer trainer = null;
		List<Trainer> trainerList = null;
		ModelAndView mav = new ModelAndView("view_trainer");
		try {
			trainer = trainerService.getTrainer(trainerId);
			trainerList = trainerService.getTrainerDetails();
		} catch (TrainingProcessException e) {
			mav = new ModelAndView("view_trainer");
			mav.addObject("errorMessage", e.getMessage());

		}
		mav.addObject("trainerList", trainerList);
		mav.addObject(trainer);

		return mav;
	}

	@RequestMapping("/editTrainer")
	public ModelAndView editTrainer(@RequestParam("vendorId") int vendorId, @RequestParam("trainerId") int trainerId) {
		Trainer trainer = null;
		List<Vendor> vendorList = null;
		ModelAndView mav = null;
		try {
			trainer = trainerService.getTrainer(trainerId);
			vendorList = vendorService.getVendorDetails();
		} catch (TrainingProcessException e) {
			mav = new ModelAndView("view_trainer");
			mav.addObject("errorMessage", e.getMessage());
			return mav;

		}

		mav = new ModelAndView("trainer_registration", "trainer", trainer);

		mav.addObject("vendorList", vendorList);
		mav.addObject("vendorId", vendorId);
		return mav;
	}

	@RequestMapping("/viewTrainerDetails")
	public ModelAndView getTrainerDetails() {
		List<Trainer> trainerList = null;
		ModelAndView mav = null;
		try {
			trainerList = trainerService.getTrainerDetails();
		} catch (TrainingProcessException e) {
			mav = new ModelAndView("view_trainer");
			mav.addObject("errorMessage", e.getMessage());
			return mav;
		}
		mav = new ModelAndView("view_trainer", "trainerList", trainerList);
		return mav;

	}

}
