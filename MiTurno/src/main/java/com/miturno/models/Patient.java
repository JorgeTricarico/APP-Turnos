package com.miturno.models;

import com.miturno.models.enums.DocumentTipe;
import java.io.Serializable;
import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.Where;

/**
 *
 * @author Leonardo Terlizzi
 */

@Entity
@Data
@Table(name = "patients")
@SQLDelete(sql = "UPDATE patients SET deleted = true WHERE id=?")
@Where(clause= "deleted=false")
public class Patient implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name of patient cannot be null")
    //@Column(length= 20, nullable=false)
    private String name;

    @NotBlank(message = "Last name of patient cannot be null")
    @Column(length= 30, nullable=false)
    private String last_name;
    
    @Enumerated(value = EnumType.STRING)
    private DocumentTipe documentTipe;

    @NotNull(message = "Document of patient cannot be null")
    @Column(unique = true, nullable = false)
    private Long document;
    
    @Column(length= 30, nullable=false)
    private String phone;
    
    @Column(length= 50, nullable=false)
    private String mail;
    
    @Column(nullable=false)
    private boolean particular;
    
    @Column(length= 50, nullable=false)
    private String social_work;
    
    @Column(columnDefinition= "TEXT", length=5000)
    private String clinic_history;
    
    //private Turn turn; 
    //not implemented yet
    
    @CreationTimestamp
    @Column(updatable = false)
    private Timestamp createAt;

    @UpdateTimestamp
    private Timestamp updateAt;

    private Boolean deleted = false;
    
}
