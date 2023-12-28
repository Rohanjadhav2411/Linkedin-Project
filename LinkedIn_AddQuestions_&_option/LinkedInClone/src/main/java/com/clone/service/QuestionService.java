package com.clone.service;

import com.clone.model.Question;

public interface QuestionService {

	// method to add question and option
	Question addQuestion(Question question);

	// method to delete Question and options
	String deleteQuestion(Long id);
}
