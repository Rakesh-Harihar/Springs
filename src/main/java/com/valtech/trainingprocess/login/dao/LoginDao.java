package com.valtech.trainingprocess.login.dao;

import com.valtech.trainingprocess.common.exception.TrainingProcessException;
import com.valtech.trainingprocess.login.model.Login;

public interface LoginDao {

	Login validateUser(Login login) throws TrainingProcessException;

}
