package com.valtech.trainingprocess.feedback.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.valtech.trainingprocess.feedback.dao.FeedbackDao;
import com.valtech.trainingprocess.feedback.model.Feedback;

@Service
public class FeedbackServiceImpl implements FeedbackService {

	@Autowired
	private FeedbackDao feedbackdao;
	
	@Override
	public boolean saveFeedbackDetail(Feedback feedback) {
	
		return feedbackdao.saveFeedbackDetail(feedback);
	}

	@Override
	public List<Feedback> getFeedback() {
		
		return feedbackdao.getFeedback();
	}


}
