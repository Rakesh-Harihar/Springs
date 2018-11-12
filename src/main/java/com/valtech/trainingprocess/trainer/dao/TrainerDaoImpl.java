package com.valtech.trainingprocess.trainer.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.valtech.trainingprocess.common.exception.TrainingProcessException;
import com.valtech.trainingprocess.common.util.CommonUtil;
import com.valtech.trainingprocess.trainer.model.Trainer;

@Transactional
@Repository
public class TrainerDaoImpl implements TrainerDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public boolean saveTrainerDetail(Trainer trainer) throws TrainingProcessException {
		boolean success = false;
		String query = "insert into trainer set trainer_name=?, training_subject=?, toc=?, toc_filename=?, address1=?, address2=?, city=?, "
				+ "state=?, pincode=?, vendor_id=?, phone=?, profile=?, profile_filename=?, created_by=?, created_date=?";

		int rows = 0;
		try {
			rows = jdbcTemplate.update(query,
					new Object[] { trainer.getTrainerName(), trainer.getSubject(), trainer.getToc(),
							trainer.getTocFileName(), trainer.getAddress1(), trainer.getAddress2(), trainer.getCity(),
							trainer.getState(), trainer.getPincode(), trainer.getVendorId(), trainer.getPhone(),
							trainer.getProfile(), trainer.getProfileFileName(), trainer.getCreatedBy(), new Date() });
		} catch (DataAccessException e) {
			System.out.println(e.getMessage());

		}
		if (rows == 0) {
			throw new TrainingProcessException("Sorry!! Something went wrong. Please try after sometime");
		}
		if (rows > 0)
			success = true;
		return success;
	}

	@Override
	public List<Trainer> getTrainerDetails() {

		List<Trainer> DataList = new ArrayList<>();
		String query = "select v.vendor_name,t.trainer_name,t.training_subject,t.toc, t.profile, t.address1,t.address2,t.city,t.state,"
				+ "t.vendor_id, t.pincode, t.phone, t.toc_filename, t.profile_filename from trainer t ,vendor v where v.vendor_id=t.vendor_id";
		try {
			DataList = jdbcTemplate.query(query, new RowMapper<Trainer>() {
				@Override
				public Trainer mapRow(ResultSet rs, int row) throws SQLException {
					return new Trainer(rs.getString(2), rs.getString(3), CommonUtil.getBlobFile(rs.getBlob(4)),
							CommonUtil.getBlobFile(rs.getBlob(5)), rs.getString(6), rs.getString(7), rs.getString(8),
							rs.getString(9), rs.getInt(10), rs.getInt(11), rs.getString(1), rs.getString(12), 0,
							rs.getString(13), rs.getString(14));
				}
			});
		} catch (Exception e) {
		}

		return DataList;

	}

	@Override
	public Trainer getTrainer(int trainerId) throws TrainingProcessException {
		Trainer trainer = null;
		String query = "select t.trainer_name, t.training_subject, t.toc, t.profile, t.address1,t.address2,t.city,t.state, "
				+ "v.vendor_id,t.pincode, v.vendor_name, t.phone , t.trainer_id, t.toc_filename, "
				+ "t.profile_filename from trainer t ,vendor v where v.vendor_id=t.vendor_id and t.trainer_id=?";
		try {
			trainer = jdbcTemplate.queryForObject(query, new Object[] { trainerId }, new TrainerRowMap());
		} catch (Exception e) {
			System.out.println("exception");
		}
		if (trainer == null) {
			throw new TrainingProcessException("Sorry!! Something went wrong. Please try after sometime");
		}
		return trainer;

	}

	@Override
	public void updateTrainerDetail(Trainer trainer) {
		String query = null;
		if(trainer.getTocFileName()=="" && trainer.getProfileFileName()==""){
			query = "update trainer set trainer_name=?, training_subject=?, address1=?, address2=?, city=?, state=?, pincode=?, vendor_id=?, phone=?, modified_by=?, modified_date=? where trainer_id=?";
			
			jdbcTemplate.update(query,
					new Object[] { trainer.getTrainerName(), trainer.getSubject(), trainer.getAddress1(),
							trainer.getAddress2(), trainer.getCity(), trainer.getState(), trainer.getPincode(),
							trainer.getVendorId(), trainer.getPhone(), trainer.getModifiedBy(), new Date(),
							trainer.getTrainerId() });		
		}
		else if(trainer.getTocFileName()==""){
			query = "update trainer set trainer_name=?, training_subject=?, profile=?, profile_filename=?, address1=?, address2=?, city=?, state=?, pincode=?, vendor_id=?, phone=?, modified_by=?, modified_date=? where trainer_id=?";
			
			jdbcTemplate.update(query,
					new Object[] { trainer.getTrainerName(), trainer.getSubject(), trainer.getProfile(),
							trainer.getProfileFileName(), trainer.getAddress1(),
							trainer.getAddress2(), trainer.getCity(), trainer.getState(), trainer.getPincode(),
							trainer.getVendorId(), trainer.getPhone(), trainer.getModifiedBy(), new Date(),
							trainer.getTrainerId() });		
		}
		else if(trainer.getProfileFileName()==""){
			query = "update trainer set trainer_name=?, training_subject=?, toc=?, toc_filename=?, address1=?, address2=?, city=?, state=?, pincode=?, vendor_id=?, phone=?, modified_by=?, modified_date=? where trainer_id=?";
			
			jdbcTemplate.update(query,
					new Object[] { trainer.getTrainerName(), trainer.getSubject(), trainer.getToc(),
							trainer.getTocFileName(), trainer.getAddress1(),
							trainer.getAddress2(), trainer.getCity(), trainer.getState(), trainer.getPincode(),
							trainer.getVendorId(), trainer.getPhone(), trainer.getModifiedBy(), new Date(),
							trainer.getTrainerId() });
		}
		else{
			query = "update trainer set trainer_name=?, training_subject=?, toc=?, profile=?, toc_filename=?, profile_filename=?, address1=?, address2=?, city=?, state=?, pincode=?, vendor_id=?, phone=?, modified_by=?, modified_date=? where trainer_id=?";
			
			jdbcTemplate.update(query,
					new Object[] { trainer.getTrainerName(), trainer.getSubject(), trainer.getToc(), trainer.getProfile(),
							trainer.getTocFileName(), trainer.getProfileFileName(), trainer.getAddress1(),
							trainer.getAddress2(), trainer.getCity(), trainer.getState(), trainer.getPincode(),
							trainer.getVendorId(), trainer.getPhone(), trainer.getModifiedBy(), new Date(),
							trainer.getTrainerId() });			
		}

	}

	@Override
	public List<Trainer> getTrainerList(int id) throws TrainingProcessException {
		List<Trainer> trainerList = null;

		try {
			String query = "select t.trainer_name, t.training_subject, t.toc, t.profile, t.address1, t.address2, t.city, t.state, "
					+ "t.Pincode, v.vendor_name, t.phone, t.trainer_id, t.toc_filename, t.profile_filename from trainer t ,vendor v where t.vendor_id=v.vendor_id and t.vendor_id=?";
			trainerList = jdbcTemplate.query(query, new Object[] { id }, new TrainerRowMapper());

		} catch (Exception e) {
		}
		if (trainerList == null) {
			throw new TrainingProcessException("Sorry ! Something Went Wrong. Please try after sometime.");
		}
		return trainerList;
	}

}

class TrainerRowMapper implements RowMapper<Trainer> {

	@Override
	public Trainer mapRow(ResultSet rs, int row) throws SQLException {
		return new Trainer(rs.getString(1), rs.getString(2), CommonUtil.getBlobFile(rs.getBlob(3)),
				CommonUtil.getBlobFile(rs.getBlob(4)), rs.getString(5), rs.getString(6), rs.getString(7),
				rs.getString(8), 0, rs.getInt(9), rs.getString(10), rs.getString(11), rs.getInt(12), rs.getString(13),
				rs.getString(14));
	}

}

class TrainerRowMap implements RowMapper<Trainer> {

	@Override
	public Trainer mapRow(ResultSet rs, int row) throws SQLException {
		return new Trainer(rs.getString(1), rs.getString(2), CommonUtil.getBlobFile(rs.getBlob(3)),
				CommonUtil.getBlobFile(rs.getBlob(4)), rs.getString(5), rs.getString(6), rs.getString(7),
				rs.getString(8), rs.getInt(9), rs.getInt(10), rs.getString(11), rs.getString(12), rs.getInt(13),
				rs.getString(14), rs.getString(15));
	}

}
