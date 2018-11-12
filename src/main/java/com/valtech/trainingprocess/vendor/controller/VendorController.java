package com.valtech.trainingprocess.vendor.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.valtech.trainingprocess.common.exception.TrainingProcessException;
import com.valtech.trainingprocess.trainer.model.Trainer;
import com.valtech.trainingprocess.trainer.service.TrainerService;
import com.valtech.trainingprocess.vendor.model.Vendor;
import com.valtech.trainingprocess.vendor.service.VendorService;

@Controller
public class VendorController {

	@Autowired
	private VendorService vendorService;
	
	@Autowired
	private TrainerService trainerService;

	@RequestMapping("/vendorRegistration")
	public ModelAndView Register() {
		ModelAndView modelAndView = new ModelAndView("vendor_registration", "vendor", new Vendor());
		return modelAndView;
	}

	@RequestMapping("/saveVendor")
	public ModelAndView saveVendorDetail(@Valid @ModelAttribute("vendor") Vendor vendor, BindingResult result,
			HttpSession httpSession) {
		ModelAndView mav = null;
		List<Vendor> vendorList = null;

		if (result.hasErrors()) {
			mav = new ModelAndView("vendor_registration");
			return mav;
		}

		try {
			vendor.setModifiedBy((String) httpSession.getAttribute("user"));
			vendorService.saveVendorDetail(vendor);
			vendorList = vendorService.getVendorDetails();
		} catch (TrainingProcessException e) {
			mav = new ModelAndView("vendor_registration");
			mav.addObject("errorMessage", e.getMessage());
			return mav;
		}
		mav = new ModelAndView("view_vendor");
		mav.addObject("vendorList", vendorList);
		return mav;

	}

	@RequestMapping("/viewVendorDetails")
	public ModelAndView getVendorDetails() {
		ModelAndView mav = null;
		List<Vendor> vendorList = null;
		try {
			vendorList = vendorService.getVendorDetails();
		} catch (TrainingProcessException e) {
			mav = new ModelAndView("view_vendor");
			mav.addObject("errorMessage", e.getMessage());
			return mav;
		}
		mav = new ModelAndView("view_vendor", "vendorList", vendorList);
		return mav;

	}

	@RequestMapping("/updateVendorDetail")
	public ModelAndView saveUpdatedVendor(@Valid @ModelAttribute("vendor") Vendor vendor, BindingResult result,
			HttpSession httpSession) {
		ModelAndView mav = null;
		List<Vendor> vendorList = null;
		if (result.hasErrors()) {
			mav = new ModelAndView("vendor_registration","vendor",vendor);
			return mav;
		}
		try {
			vendor.setCreatedBy((String) httpSession.getAttribute("user"));
			vendorService.updateVendorDetail(vendor);
			vendorList = vendorService.getVendorDetails();

		} catch (TrainingProcessException e) {
			mav = new ModelAndView("vendor_registration");
			mav.addObject("errorMessage", e.getMessage());
			return mav;
		}
		mav = new ModelAndView("view_vendor");
		mav.addObject("vendorList", vendorList);
		return mav;
	}

	@RequestMapping("/editVendor")
	public ModelAndView editVendor(@Valid @RequestParam("vendorId") int vendorId) {
		ModelAndView modelAndView = null;
		Vendor vendor = null;
		try {
			vendor = vendorService.getVendor(vendorId);

		} catch (TrainingProcessException e) {
			modelAndView = new ModelAndView("vendor_registration");
			modelAndView.addObject("errorMessage", e.getMessage());
			return modelAndView;
		}
		modelAndView = new ModelAndView("vendor_registration", "vendor", vendor);
		return modelAndView;
	}

	@RequestMapping("/viewTrainerList")
	public ModelAndView viewTrainerList(@RequestParam("vendorId") int vendorId) {
		ModelAndView mav = null;
		Vendor vendor = null;
		List<Trainer> trainerList = null;
		try {
			vendor = vendorService.getVendor(vendorId);
			trainerList = trainerService.getTrainerList(vendorId);

		} catch (TrainingProcessException e) {
			mav = new ModelAndView("view_trainer");
			mav.addObject("errorMessage", e.getMessage());
			return mav;
		}
		mav = new ModelAndView("view_trainer");
		mav.addObject("trainerList", trainerList);
		mav.addObject("vendor", vendor);
		return mav;
	}
}
