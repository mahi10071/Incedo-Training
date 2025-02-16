package com.example.demo.model;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Component
@Entity
@Table(name = "category") // Ensure this matches the table name in your DB
//@Table
public class category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
	/*
	 * @ManyToOne
	 * 
	 * @JoinColumn(name = "category_id", referencedColumnName = "id", nullable =
	 * false) private category category;
	 */
    
	/*
	 * @OneToOne(mappedBy = "category") private Question question;
	 */
    
    @Column
    private Long id;  // Make sure this matches the column name in your DB
    @Column
    private String name;
    @Column
    private String description;


    
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAction() {
		return getAction();
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}

    // Getters and Setters

//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getTitle() {
//        return title;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//}
