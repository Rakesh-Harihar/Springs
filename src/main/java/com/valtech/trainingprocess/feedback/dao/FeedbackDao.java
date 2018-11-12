package com.valtech.trainingprocess.feedback.dao;

import java.util.List;

import com.valtech.trainingprocess.feedback.model.Feedback;


public interface FeedbackDao {
	boolean saveFeedbackDetail(Feedback feedback);

	List<Feedback> getFeedback();
}
