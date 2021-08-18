package com.springrolebasejwt.domain;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity @Data @NoArgsConstructor @AllArgsConstructor
@Table(name="roles")
public class Role {

	 @Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String name;
	
}
