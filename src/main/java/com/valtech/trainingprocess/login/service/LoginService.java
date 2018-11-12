package com.valtech.trainingprocess.login.service;

import com.valtech.trainingprocess.common.exception.TrainingProcessException;
import com.valtech.trainingprocess.login.model.Login;

public interface LoginService {

	Login validateUser(Login login) throws TrainingProcessException;

}
