package com.valtech.trainingprocess.training.dao;

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

import com.valtech.trainingprocess.training.model.Category;
import com.valtech.trainingprocess.training.model.Status;
import com.valtech.trainingprocess.training.model.Trainee;

import com.valtech.trainingprocess.training.model.Training;

@Transactional
@Repository
public class TrainingDaoImpl implements TrainingDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void saveTrainingRequest(Training training) throws TrainingProcessException {
		int rows = 0;
		String query = "insert into training set category_id=?,topic=?, nop=?, remark=?,tentative_start_date=?, training_status_id=?, training_toc=?, training_toc_filename=?, created_by=?, created_date=?";
		try {
			rows = jdbcTemplate.update(query, new Object[] { training.getCategory(), training.getTopic(),

					training.getNumberOfPeople(), training.getRemarks(), training.getTentativeStartDate(),
					training.getStatusId(), training.getTrainingToc(), training.getTrainingFileName(),
					training.getCreatedBy(), new Date() });
		} catch (DataAccessException e) {
		}
		if (rows == 0)
			throw new TrainingProcessException("Sorry ! Something Went Wrong. Please try after sometime.");
	}

	@Override
	public List<Training> getTrainingRequest(String currentUser) throws TrainingProcessException {
		List<Training> trainingList = null;
		try {
			trainingList = jdbcTemplate
					.query("select t.training_id, tc.category_name, t.topic, t.nop, t.remark, t.tentative_start_date, ts.training_status, "
							+ " t.training_toc, t.training_toc_filename from training t, training_category tc, training_status ts where tc.category_id=t.category_id and t.training_status_id=ts.training_status_id"
							+ " and t.created_by = ? ", new Object[] { currentUser }, new RowMapper<Training>() {
								@Override
								public Training mapRow(ResultSet rs, int row) throws SQLException {
									return new Training(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4),
											rs.getString(5), rs.getString(6), null, null, null, null, rs.getString(7),
											null, null, CommonUtil.getBlobFile(rs.getBlob(8)), rs.getString(9));
								}
							});
		} catch (Exception e) {
		}
		if (trainingList == null) {
			throw new TrainingProcessException("Sorry ! Something Went Wrong. Please try after sometime.");
		}
		return trainingList;
	}

	@Override
	public List<Training> getTrainingRequestAll() throws TrainingProcessException {
		List<Training> trainingList = null;
		try {
			trainingList = jdbcTemplate
					.query("select t.training_id, tc.category_name, t.topic, t.nop, t.remark, t.tentative_start_date, ts.training_status, "
							+ "t.created_by, t.training_toc,t.training_toc_filename from training t, training_category tc, training_status ts where tc.category_id = t.category_id and "
							+ "t.training_status_id=ts.training_status_id", new RowMapper<Training>() {
								@Override
								public Training mapRow(ResultSet rs, int row) throws SQLException {
									return new Training(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4),
											rs.getString(5), rs.getString(6), null, null, null, null, rs.getString(7),
											rs.getString(8), null, CommonUtil.getBlobFile(rs.getBlob(9)),
											rs.getString(10));
								}
							});
		} catch (Exception e) {
		}
		if (trainingList == null) {
			throw new TrainingProcessException("Sorry ! Something Went Wrong. Please try after sometime.");
		}
		return trainingList;
	}

	@Override
	public List<Category> getCategoryList() throws TrainingProcessException {
		List<Category> catList = new ArrayList<>();
		try {
			catList = jdbcTemplate.query("select category_id, category_name from training_category",
					new RowMapper<Category>() {
						@Override
						public Category mapRow(ResultSet rs, int row) throws SQLException {
							return new Category(rs.getInt(1), rs.getString(2));
						}
					});
		} catch (Exception e) {
		}
		if (catList == null) {
			throw new TrainingProcessException("Sorry ! Something Went Wrong. Please try after sometime.");
		}
		return catList;
	}

	@Override
	public List<Training> getTrainingDetails() throws TrainingProcessException {
		List<Training> trainingList = null;
		try {
			trainingList = jdbcTemplate.query(
					"select t.training_id, t.topic, t.created_by, t.training_start_date, t.training_end_date, tr.trainer_name, v.vendor_name  from training t , trainer tr, vendor v where v.vendor_id = t.vendor_id and tr.trainer_id=t.trainer_id",
					new RowMapper<Training>() {
						@Override
						public Training mapRow(ResultSet rs, int row) throws SQLException {
							return new Training(rs.getInt(1), null, rs.getString(2), 0, null, null, rs.getString(7),
									rs.getString(6), rs.getString(4), rs.getString(5), null, rs.getString(3), null,
									null, null);
						}
					});
		} catch (Exception e) {
		}
		if (trainingList == null) {
			throw new TrainingProcessException("Sorry ! Something Went Wrong. Please try after sometime.");
		}
		return trainingList;
	}

	@Override
	public Training getTraining(int trainingId) throws TrainingProcessException {
		Training training = null;
		try {
			String query = "SELECT training_id,training_status from training a, training_status b where training_id=? and a.training_status_id=b.training_status_id";
			training = jdbcTemplate.queryForObject(query, new Object[] { trainingId }, new TrainingRowMapper());
		} catch (Exception e) {
		}
		if (training == null) {
			throw new TrainingProcessException("Sorry ! Something Went Wrong. Please try after sometime.");
		}
		return training;
	}

	@Override
	public boolean updateStatus(Training training) throws TrainingProcessException {
		boolean success = false;
		String rejected = "3";
		String query = null;
		int row = 0;
		try {
			if(training.getStatus().equals(rejected))
			{
				query = "Update training set training_status_id=?, modified_by=?, modified_date=? where training_id = ?";
				row = jdbcTemplate.update(query,
						new Object[] { training.getStatus(), training.getUpdatedBy(), new Date(), training.getTrainingId() });
			}
			else
			{
				query = "Update training set vendor_id=?, trainer_id =?, training_status_id=?, training_start_date=?, training_end_date=?, modified_by=?, modified_date=? where training_id = ?";
				row = jdbcTemplate.update(query,
						new Object[] { training.getVendorId(), training.getTrainerId(), training.getStatus(),
								training.getStartDate(), training.getEndDate(), training.getUpdatedBy(), new Date(),
								training.getTrainingId() });				
			}
		} catch (DataAccessException e) {
		}
		if (row > 0)
			success = true;
		return success;
	}
	
	@Override
	public Training getTrainingDetail(int trainingId) throws TrainingProcessException {
		Training training = null;
		try {
			String query = "Select t.topic,t.created_by,tc.category_name,t.training_start_date,t.training_end_date,t.nop,t.tentative_start_date,t.trainer_id, v.vendor_name, tr.trainer_name, t.training_toc, t.training_toc_filename, tr.toc, tr.toc_filename, tr.profile, tr.profile_filename from training t, training_category tc, trainer tr, vendor v where t.category_id=tc.category_id and t.vendor_id=v.vendor_id and t.trainer_id=tr.trainer_id and t.training_id=?";
			training = jdbcTemplate.queryForObject(query, new Object[] { trainingId }, new TrainingRowMap());
		} catch (Exception e) {
		}
		if (training == null) {
			throw new TrainingProcessException("Sorry ! Something Went Wrong. Please try after sometime.");
		}
		return training;
	}

	@Override
	public void saveTraineeDetail(Trainee trainee) throws TrainingProcessException {
		int row = 0;
		try {
			String query = "insert into trainee(training_id,employee_id,name,project) values (?,?,?,?)";
			row = jdbcTemplate.update(query, new Object[] { trainee.getTrainingId(), trainee.getEmployeeId(),
					trainee.getName(), trainee.getProject() });
		} catch (DataAccessException e) {
		}
		if (row == 0)
			throw new TrainingProcessException("Sorry ! Something Went Wrong. Please try after sometime.");
	}

	@Override
	public List<Trainee> getTraineeList(int trainingId) throws TrainingProcessException {
		List<Trainee> traineeList = null;
		try {
			traineeList = jdbcTemplate.query("select employee_id,name,project from trainee where training_id=?",
					new Object[] { trainingId }, new RowMapper<Trainee>() {
						@Override
						public Trainee mapRow(ResultSet rs, int row) throws SQLException {
							return new Trainee(rs.getInt(1), rs.getString(2), rs.getString(3));
						}
					});
		} catch (Exception e) {
		}
		if (traineeList == null) {
			throw new TrainingProcessException("Sorry ! Something Went Wrong. Please try after sometime.");
		}
		return traineeList;
	}

	@Override
	public List<Status> getAllStatus() throws TrainingProcessException {
		List<Status> catList = new ArrayList<>();
		try {
			catList = jdbcTemplate.query("select training_status_id,training_status from training_status",
					new StatusRowMapper());
		} catch (Exception e) {
		}
		if (catList == null) {
			throw new TrainingProcessException("Sorry ! Something Went Wrong. Please try after sometime.");
		}
		return catList;
	}

	
}

class TrainingRowMapper implements RowMapper<Training> {
	@Override
	public Training mapRow(ResultSet rs, int row) throws SQLException {
		return new Training(rs.getInt(1), null, null, 0, null, null, null, null, null, null, rs.getString(2), null,
				null, null, null);
	}

}

class StatusRowMapper implements RowMapper<Status> {
	public Status mapRow(ResultSet rs, int row) throws SQLException {
		return new Status(rs.getInt(1), rs.getString(2));
	}
}

class TrainingRowMap implements RowMapper<Training> {
	@Override
	public Training mapRow(ResultSet rs, int row) throws SQLException {
		return new Training(0, rs.getString(3), rs.getString(1), rs.getInt(6), null, rs.getString(7), rs.getString(9),
				rs.getString(10), 0, rs.getInt(8), rs.getString(4), rs.getString(5), null, 0, rs.getString(2), null,
				CommonUtil.getBlobFile(rs.getBlob(11)), rs.getString(12), CommonUtil.getBlobFile(rs.getBlob(13)),
				rs.getString(14), CommonUtil.getBlobFile(rs.getBlob(15)), rs.getString(16));

	}
}
