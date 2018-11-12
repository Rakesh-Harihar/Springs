package com.valtech.trainingprocess.feedback.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.valtech.trainingprocess.feedback.model.Feedback;

@Repository
public class FeedbackDaoImpl implements FeedbackDao{

	@Override
	public boolean saveFeedbackDetail(Feedback feedback) {
	    boolean sucess=false;
	    
		return sucess;
	}

	@Override
	public List<Feedback> getFeedback() {
		List<Feedback> FeedbackList = null;
		return FeedbackList;
	}

}
