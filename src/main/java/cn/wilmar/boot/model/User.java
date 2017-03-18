package cn.wilmar.boot.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User {
    @Id
    @GeneratedValue
    private Long id;
    
    private String name;
    private LocalDate created;
    
    public User() {
    }
    
    public String getName() {
    	return name;
    }
    
    public User setName(String name) {
    	this.name = name;
    	return this;
    }
    
    public LocalDate getCreated() {
    	return created;
    }
    
    public User setCreated(LocalDate created) {
    	this.created = created;
    	return this;
    }
    
    
    public Long getId() {
        return id;
    }   
    
    public User setId(Long id) {
        this.id = id;
        return this;
    }


    public User(String name) {
	    this.name = name;
        this.created = LocalDate.now();
    }

}