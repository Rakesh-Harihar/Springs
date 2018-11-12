package com.valtech.trainingprocess.login.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.valtech.trainingprocess.common.exception.TrainingProcessException;
import com.valtech.trainingprocess.login.dao.LoginDao;
import com.valtech.trainingprocess.login.model.Login;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private LoginDao loginDao;

	@Override
	public Login validateUser(Login login) throws TrainingProcessException {
		return loginDao.validateUser(login);
	}

	

}
