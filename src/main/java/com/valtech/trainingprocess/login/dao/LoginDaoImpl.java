package com.valtech.trainingprocess.login.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.valtech.trainingprocess.common.exception.TrainingProcessException;
import com.valtech.trainingprocess.login.model.Login;



@Repository
public class LoginDaoImpl implements LoginDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public Login validateUser(Login login) throws TrainingProcessException {

		String query = "select username, password,role from login where username=? and password=?";
		Login loginDetail = null;
		try {
			loginDetail = jdbcTemplate.queryForObject(query, new LoginRowMapper(),
					new Object[] { login.getUserName(), login.getPassword() });
		} catch (DataAccessException e) {

		}

		if (loginDetail == null) {
			throw new TrainingProcessException("User and Password is not Matching with database");
		}

		return loginDetail;
	}

}

class LoginRowMapper implements RowMapper<Login> {
	@Override
	public Login mapRow(ResultSet rs, int row) throws SQLException {

		return new Login(rs.getString(1), rs.getString(2), rs.getString(3));
	}
}
