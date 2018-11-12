package com.valtech.trainingprocess.vendor.dao;

import java.util.List;

import com.valtech.trainingprocess.common.exception.TrainingProcessException;
import com.valtech.trainingprocess.vendor.model.Vendor;

public interface VendorDao {

	public void saveVendorDetail(Vendor vendor) throws TrainingProcessException;

	public List<Vendor> getVendorDetails() throws TrainingProcessException;

	public void updateVendorDetail(Vendor vendor) throws TrainingProcessException;

	public Vendor getVendor(int vendorId) throws TrainingProcessException;


}
