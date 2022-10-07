package com.miturno.models;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.Where;

import com.miturno.models.enums.DocumentTipe;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;
 
@Entity
@Data
@Table(name = "users")
@SQLDelete(sql = "UPDATE users SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
        
        @NotBlank(message = "Name cannot be null")
//	@Column(length = 30, nullable = false)
	private String name;
        
//        @NotBlank(message = "Lastname cannot be null")
//	@Column(length = 40, nullable = false)
	private String lastName;
	
//        @NotBlank(message = "DocumentType cannot be null")
	@Enumerated(value = EnumType.STRING)
	private DocumentTipe DocumentTipe;
	
//        @NotNull(message = "Document cannot be null")
//	@Column(unique = true, nullable = false)
	private Long document;
	
//        @Email(message = "Email should be valid")
//	@Column(nullable = false)
	private String email;
        
//        @NotBlank(message = "Password cannot be null")
//	@Column(nullable = false)
	private String password;

//	@OneToOne(fetch = FetchType.EAGER)
//	private Roles roles;

	@CreationTimestamp
	@Column(updatable = false)
	private Timestamp createAt;

	@UpdateTimestamp
	private Timestamp updateAt;

	private Boolean deleted = false;

}
