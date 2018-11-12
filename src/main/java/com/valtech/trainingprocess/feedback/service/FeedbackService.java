package com.valtech.trainingprocess.feedback.service;

import java.util.List;

import com.valtech.trainingprocess.feedback.model.Feedback;

public interface FeedbackService {

	boolean saveFeedbackDetail(Feedback feedback);
	
	List<Feedback> getFeedback();
}
