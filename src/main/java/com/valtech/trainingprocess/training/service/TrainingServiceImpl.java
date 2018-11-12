package com.valtech.trainingprocess.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.valtech.trainingprocess.common.exception.TrainingProcessException;
import com.valtech.trainingprocess.training.dao.TrainingDao;
import com.valtech.trainingprocess.training.model.Category;
import com.valtech.trainingprocess.training.model.Status;
import com.valtech.trainingprocess.training.model.Trainee;
import com.valtech.trainingprocess.training.model.Training;

@Service
public class TrainingServiceImpl implements TrainingService {

	@Autowired
	private TrainingDao trainingDao;

	@Override

	public List<Category> getCategoryList() throws TrainingProcessException {

		return trainingDao.getCategoryList();
	}

	@Override
	public void saveTrainingRequest(Training training) throws TrainingProcessException {
		trainingDao.saveTrainingRequest(training);
	}

	@Override
	public List<Training> getTrainingRequest(String currentUser) throws TrainingProcessException {
		return trainingDao.getTrainingRequest(currentUser);
	}

	@Override
	public List<Training> getTrainingRequestAll() throws TrainingProcessException {
		return trainingDao.getTrainingRequestAll();
	}

	@Override
	public Training getTraining(int trainingId) throws TrainingProcessException {
		return trainingDao.getTraining(trainingId);
	}

	@Override

	public boolean updateStatus(Training training) throws TrainingProcessException {
		return trainingDao.updateStatus(training);
	}

	@Override
	public List<Training> getTrainingDetails() throws TrainingProcessException {
		return trainingDao.getTrainingDetails();
	}

	@Override
	public List<Status> getAllStatus() throws TrainingProcessException {

		return trainingDao.getAllStatus();
	}

	@Override
	public Training getTrainingDetail(int trainingId) throws TrainingProcessException {
		return trainingDao.getTrainingDetail(trainingId);
	}

	@Override
	public void saveTraineeDetail(Trainee trainee) throws TrainingProcessException {
		trainingDao.saveTraineeDetail(trainee);
	}

	@Override
	public List<Trainee> getTraineeList(int trainingId) throws TrainingProcessException {
		return trainingDao.getTraineeList(trainingId);
	}

}
