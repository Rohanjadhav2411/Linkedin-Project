package com.clone.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clone.model.Question;
import com.clone.service.QuestionService;

@RestController
@RequestMapping("/questions")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @PostMapping("/add")
    public ResponseEntity<Question> addQuestion(@RequestBody Question question) {
        Question addedQuestion = questionService.addQuestion(question);
        return new ResponseEntity<>(addedQuestion, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteQuestion(@PathVariable Long id) {
        String result = questionService.deleteQuestion(id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
