package com.miturno.models;

import java.sql.Timestamp;
import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.Where;
import com.miturno.models.enums.DocumentTipe;
import java.io.Serializable;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Data;
//import javax.validation.constraints.NotNull;

@Entity
@Data
@Table(name = "users")
@SQLDelete(sql = "UPDATE users SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "Name of user cannot be null")
//  @Column(length = 30, nullable = false)
    private String name;

    @NotBlank(message = "Lastname of user cannot be null")
//  @Column(length = 40, nullable = false)
    private String lastName;

    @NotNull(message = "DocumentType of user cannot be null")
    @Enumerated(value = EnumType.STRING)
    private DocumentTipe DocumentTipe;

    @NotNull(message = "Document of user cannot be null")
//  @Column(unique = true, nullable = false)
    private Long document;

    @Email(message = "Email of user should be valid")
//  @Column(nullable = false)
    private String email;

  @NotBlank(message = "Password of user cannot be null")
//  @Column(nullable = false)
    private String password;


  @OneToOne(fetch = FetchType.EAGER)
  private Role roles;
    
    @CreationTimestamp
    @Column(updatable = false)
    private Timestamp createAt;

    @UpdateTimestamp
    private Timestamp updateAt;

    private Boolean deleted = false;

}
