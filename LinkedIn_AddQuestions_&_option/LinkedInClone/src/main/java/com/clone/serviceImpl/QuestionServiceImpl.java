package com.clone.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clone.model.Options;
import com.clone.model.Question;
import com.clone.repository.OptionsRepository;
import com.clone.repository.QuestionRepository;
import com.clone.service.QuestionService;

@Service
public class QuestionServiceImpl implements QuestionService {

	@Autowired
	private QuestionRepository QuestionRepo;

	// Autowired OptionRepository.
	@Autowired
	private OptionsRepository OptionsRepo;

	// Add question with options
	@Override
	public Question addQuestion(Question question) {
		// Save the question first
		Question savedQuestion = QuestionRepo.save(question);

		// Associate the saved question ID with the options
		for (Options option : savedQuestion.getOptions()) {
			option.setQuestion(savedQuestion);
			OptionsRepo.save(option);
		}

		return savedQuestion;
	}

	// delete Question and options.
	@Override
	public String deleteQuestion(Long id) {
		// find question using question Id.
		Question question = QuestionRepo.findById(id).orElseThrow(() -> new RuntimeException("Id not found"));

		if (question != null) {
			// delete question's options
			OptionsRepo.deleteAll(question.getOptions());

			// delete Question
			QuestionRepo.delete(question);

			// return string if id deleted successfully
			return " Question with id " + id + " deleted successfully. ";
		}
		// return string if Question id not found
		return " Question with id " + id + " not Found ";
	}

}
