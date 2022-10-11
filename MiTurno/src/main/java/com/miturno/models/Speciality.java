
package com.miturno.models;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import lombok.Data;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

/**
 *
 * @author Leonardo Terlizzi
 */

@Entity
@Data
@Table(name = "specialties")
@SQLDelete(sql = "UPDATE specialties SET deleted = true WHERE id=?")
@Where(clause= "deleted=false")
public class Speciality implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @NotBlank
//    @Column(length = 30, nullable = false)
    private String name;
  
    //@OneToOne(fetch = FetchType.LAZY)
    //@ManyToMany(fetch = FetchType.LAZY)
    //private Doctor doctor_id;
    
  
    
}
