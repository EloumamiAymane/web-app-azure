package com.iga.ac.ma.demo.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Patient {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotBlank(message="le nom ne doit pas etre vide")
    @Size(min=2,message="le nom doit avoir au mois 2 caractere")
    private String name;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateNaissance;
    private boolean malade;

    @Min(value = 1, message = "le score doit être supérieur à 0")
    private int score;


}
