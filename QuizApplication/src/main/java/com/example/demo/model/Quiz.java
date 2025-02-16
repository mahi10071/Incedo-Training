package com.example.demo.model;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Component
@Entity
@Table(name="category")
public class Quiz {
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	  private int id;
    private String name;

    // No-argument constructor
   

    // Getter and setter for title
    public String getName() {
        return name;
    }

    public void setTitle(String title) {
        this.name = title;
    }
}

//import org.springframework.stereotype.Component;
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//@Component
//@Entity
//public class Quiz {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private String id;
//    private String name;
//
//   // Constructor
//   public Quiz(String id, String name) {
//        this.id = id;
//        this.name = name;
//    }
//
//    // Getters and setters
//    public String getId() {
//        return id;
//   }
////
//   public void setId(String id) {
//        this.id = id;
//    }
////
//   public String getName() {
//       return name;
//   }
////
//  public void setName(String name) {
//      this.name = name;
//    }
////
//public String getTitle() {
//	// TODO Auto-generated method stub
//	return null;
//	}
//}
//
