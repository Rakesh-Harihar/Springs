package com.valtech.trainingprocess.training.dao;

import java.util.List;

import com.valtech.trainingprocess.common.exception.TrainingProcessException;
import com.valtech.trainingprocess.training.model.Category;
import com.valtech.trainingprocess.training.model.Status;
import com.valtech.trainingprocess.training.model.Trainee;
import com.valtech.trainingprocess.training.model.Training;

public interface TrainingDao {

	public List<Category> getCategoryList() throws TrainingProcessException;

	public void saveTrainingRequest(Training training) throws TrainingProcessException;

	public List<Training> getTrainingRequest(String currentUser) throws TrainingProcessException;

	public List<Training> getTrainingRequestAll() throws TrainingProcessException;

	public Training getTraining(int trainingId) throws TrainingProcessException;

	public boolean updateStatus(Training training) throws TrainingProcessException;

	public List<Training> getTrainingDetails() throws TrainingProcessException;

	public List<Status> getAllStatus() throws TrainingProcessException;

	public Training getTrainingDetail(int trainingId) throws TrainingProcessException;

	public void saveTraineeDetail(Trainee trainee) throws TrainingProcessException;

	public List<Trainee> getTraineeList(int trainingId) throws TrainingProcessException;

}
