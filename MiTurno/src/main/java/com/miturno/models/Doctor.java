package com.miturno.models;

import java.sql.Timestamp;
//import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
//import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
//import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

//import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

/**
 *
 * @author Jorge
 */

@Entity
@Data
@Table(name = "Doctors")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Doctor extends User  {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Basic
	//@Column(nullable = false)
	private java.time.LocalTime start_time;

	@Basic
	//@Column(nullable = false)
	private java.time.LocalTime end_time;

	@Column(length = 10) //, nullable = false
	private String days;

	private Boolean available;
	
//	@JsonIgnore
//	@ManyToMany(fetch = FetchType.LAZY)
//	private List<Speciality> roles;
	
	@CreationTimestamp
    @Column(nullable = false, updatable = false)
    private Timestamp createAt;

    @UpdateTimestamp
    @Column(nullable = false)
    private Timestamp updateAt;
}
