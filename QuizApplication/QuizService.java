package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Quiz;
import com.example.demo.repository.QuizRepository;

@Service
public class QuizService {
	
//	@Autowired
	
    @Autowired
    private QuizRepository quizRepository;
//	
    // Example method to save the quiz to a database or list
    public void createQuiz(Quiz quiz) {
    	 quizRepository.save(quiz);
        // Logic to save quiz (e.g., save to a database)
        System.out.println("Quiz Created: " + quiz.getName());
    }
    

    public Iterable<Quiz> getAllQuizzes() {
        return quizRepository.findAll();
    }
}
