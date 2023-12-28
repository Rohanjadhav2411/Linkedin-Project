package com.clone.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String question;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "question")
    @JsonManagedReference
    private List<Options> options;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public List<Options> getOptions() {
		return options;
	}

	public void setOptions(List<Options> options) {
		this.options = options;
	}

    
}
