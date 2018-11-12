package com.valtech.trainingprocess.trainer.service;

import java.util.List;

import com.valtech.trainingprocess.common.exception.TrainingProcessException;
import com.valtech.trainingprocess.trainer.model.Trainer;

public interface TrainerService {

	boolean saveTrainerDetail(Trainer trainer) throws TrainingProcessException;

	List<Trainer> getTrainerDetails() throws TrainingProcessException;

	void updateTrainerDetail(Trainer trainer) throws TrainingProcessException;

	Trainer getTrainer(int trainerId) throws TrainingProcessException;
	
	public List<Trainer> getTrainerList(int vendorId) throws TrainingProcessException;

}
