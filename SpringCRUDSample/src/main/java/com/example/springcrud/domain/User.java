package com.example.springcrud.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "users")
public class User {
	
	/**
	 * ID
	 */
    @Id
    @GeneratedValue
    private Long id;
    
	/**
	 * 氏名
	 */
    private String name;
    
	/**
	 * 年齢
	 */
    private Integer age;
}
