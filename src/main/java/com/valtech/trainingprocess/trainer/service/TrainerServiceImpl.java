package com.valtech.trainingprocess.trainer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.valtech.trainingprocess.common.exception.TrainingProcessException;
import com.valtech.trainingprocess.trainer.dao.TrainerDao;
import com.valtech.trainingprocess.trainer.model.Trainer;


@Transactional
@Service
public class TrainerServiceImpl implements TrainerService {
	
	@Autowired
	private TrainerDao trainerDao; 

	public boolean saveTrainerDetail(Trainer trainer) throws TrainingProcessException{
		
		return trainerDao.saveTrainerDetail(trainer);
	}
	
	@Override
	public List<Trainer> getTrainerDetails() throws TrainingProcessException{
		
		return trainerDao.getTrainerDetails();
	}

	@Override
	public void updateTrainerDetail(Trainer trainer) throws TrainingProcessException{
		trainerDao.updateTrainerDetail(trainer);
		
	}

	@Override
	public Trainer getTrainer(int trainerId) throws TrainingProcessException {
		
		return trainerDao.getTrainer(trainerId);
	}
	

	@Override
	public List<Trainer> getTrainerList(int vendorId)throws TrainingProcessException {
		return trainerDao.getTrainerList(vendorId);
	}

}
