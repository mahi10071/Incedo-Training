/*
 * package com.example.demo.model; import java.util.Locale.Category;
 * 
 * import jakarta.persistence.Entity; import jakarta.persistence.GeneratedValue;
 * import jakarta.persistence.GenerationType; import jakarta.persistence.Id;
 * import jakarta.persistence.JoinColumn; import jakarta.persistence.ManyToOne;
 * 
 * @Entity public class Question {
 * 
 * @Id
 * 
 * @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;
 * 
 * private String questionText; private String optionA; private String optionB;
 * private String optionC; private String optionD; private String correctAnswer;
 * 
 * @ManyToOne
 * 
 * @JoinColumn(name = "category_id", nullable = false) private Category
 * category;
 * 
 * // Getters and Setters }
 */