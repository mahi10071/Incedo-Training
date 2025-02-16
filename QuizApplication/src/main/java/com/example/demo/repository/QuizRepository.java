//package com.example.demo.repository;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;
//
////@Repository
////public interface QuizRepository extends JpaRepository<Quiz, Long> {
////    // You can add custom queries here if necessary
////}
//public interface QuizRepository<quiz, Quiz> extends JpaRepository<Quiz,Long> {
//}

package com.example.demo.repository;

import com.example.demo.model.Quiz;  // Assuming your Quiz entity is in the model package
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuizRepository extends JpaRepository<Quiz,Integer> {
	}

//public interface QuizRepository extends JpaRepository<Quiz, String> {
//
//	com.example.demo.repository.Quiz save(com.example.demo.repository.Quiz quiz);
//    // You can add custom query methods here if needed
//}
