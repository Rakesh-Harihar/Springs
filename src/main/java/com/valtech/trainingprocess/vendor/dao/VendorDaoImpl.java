package com.valtech.trainingprocess.vendor.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.valtech.trainingprocess.common.exception.TrainingProcessException;
import com.valtech.trainingprocess.trainer.model.Trainer;
import com.valtech.trainingprocess.vendor.model.Vendor;

@Transactional
@Repository
public class VendorDaoImpl implements VendorDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public void saveVendorDetail(Vendor vendor) throws TrainingProcessException {

		String query = "insert into vendor(vendor_name,address1,address2,city,state,pincode,phone1,phone2,email,altemail,name1,email1,mobile1,name2,email2,mobile2,created_by,created_date) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		int row = 0;
		try {
			row = jdbcTemplate.update(query,
					new Object[] { vendor.getVendorName(), vendor.getAddress1(), vendor.getAddress2(), vendor.getCity(),
							vendor.getState(), vendor.getPincode(), vendor.getMobile(), vendor.getOfftel(),
							vendor.getEmail(), vendor.getAltemail(), vendor.getName1(), vendor.getEmail1(),
							vendor.getMobile1(), vendor.getName2(), vendor.getEmail2(), vendor.getMobile2(),
							vendor.getCreatedBy(), new Date() });
		} catch (DataAccessException e) {
		}

		if (row == 0) {
			throw new TrainingProcessException("Sorry ! Something Went Wrong. Please try after sometime.");
		}
	}

	@Override
	public List<Vendor> getVendorDetails() throws TrainingProcessException {
		List<Vendor> vendors = null;
		try {
			String query = "select vendor_name,city,state,phone1,vendor_id from vendor";
			vendors = jdbcTemplate.query(query, new Object[] {}, new GetVendorRowMapper());
		} catch (Exception e) {

		}

		if (vendors == null) {
			throw new TrainingProcessException("Sorry ! Something Went Wrong. Please try after sometime.");
		}
		return vendors;
	}

	@Override
	public Vendor getVendor(int vendorId) throws TrainingProcessException {
		Vendor vendor = null;
		try {
			String query = "SELECT vendor_id,vendor_name,address1,address2,city,state,pincode,phone1,phone2,email,altemail,name1,email1,mobile1,name2,email2,mobile2 from vendor where vendor_id=?";
			vendor = jdbcTemplate.queryForObject(query, new Object[] { vendorId }, new VendorRowMapper());
		} catch (Exception e) {

		}
		if (vendor == null) {
			throw new TrainingProcessException("Sorry ! Something Went Wrong. Please try after sometime.");
		}
		return vendor;
	}

	@Override
	public void updateVendorDetail(Vendor vendor) {
		String query = "update vendor set vendor_name=?, address1=?, address2=?, city=?, state=?, pincode=?,"
				+ "phone1=?, phone2=?, email=?, altemail=?, name1=?, email1=?, mobile1=?, name2=?, email2=?, mobile2=?, modified_by=?, modified_date=? where vendor_id=?";
		jdbcTemplate.update(query,
				new Object[] { vendor.getVendorName(), vendor.getAddress1(), vendor.getAddress2(), vendor.getCity(),
						vendor.getState(), vendor.getPincode(), vendor.getMobile(), vendor.getOfftel(),
						vendor.getEmail(), vendor.getAltemail(), vendor.getName1(), vendor.getEmail1(),
						vendor.getMobile1(), vendor.getName2(), vendor.getEmail2(), vendor.getMobile2(),
						vendor.getModifiedBy(), new Date(), vendor.getVendorId() });

	}
}

class VendorRowMapper implements RowMapper<Vendor> {
	@Override
	public Vendor mapRow(ResultSet rs, int row) throws SQLException {

		return new Vendor(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
				rs.getString(6), rs.getInt(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11),
				rs.getString(12), rs.getString(13), rs.getString(14), rs.getString(15), rs.getString(16),
				rs.getString(17));
	}
}

class GetVendorRowMapper implements RowMapper<Vendor> {
	@Override
	public Vendor mapRow(ResultSet rs, int row) throws SQLException {
		return new Vendor(rs.getInt(5), rs.getString(1), null, null, rs.getString(2), rs.getString(3), 0,
				rs.getString(4), null, null, null, null, null, null, null, null, null);
	}
}
