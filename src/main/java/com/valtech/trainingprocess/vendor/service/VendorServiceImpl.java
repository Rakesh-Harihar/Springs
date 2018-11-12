package com.valtech.trainingprocess.vendor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.valtech.trainingprocess.common.exception.TrainingProcessException;
import com.valtech.trainingprocess.vendor.dao.VendorDao;
import com.valtech.trainingprocess.vendor.model.Vendor;

@Service
public class VendorServiceImpl implements VendorService {

	@Autowired
	private VendorDao vendorDao;

	@Override
	public void saveVendorDetail(Vendor vendor) throws TrainingProcessException{
		vendorDao.saveVendorDetail(vendor);

	}

	@Override
	public List<Vendor> getVendorDetails() throws TrainingProcessException {
		return vendorDao.getVendorDetails();
	}

	@Override
	public void updateVendorDetail(Vendor vendor) throws TrainingProcessException{
		vendorDao.updateVendorDetail(vendor);

	}

	@Override
	public Vendor getVendor(int vendorId)throws TrainingProcessException {
		return vendorDao.getVendor(vendorId);
	}

	
}
