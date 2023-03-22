package com.smart.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="CONTACT")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ContactEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long cId;
	private String name;
	private String secondName;
	private String work;
	private String email;
	private String image;
	@Column(length = 5000)
	private String description;
	private String phone;
	
	@ManyToOne
	private UserEntity userEntity;
	
	
}
