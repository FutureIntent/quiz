package com.example.quiz.dto;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "quiz")
@Table(name = "quiz",  schema="quiz")
public class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "quiz_id", updatable = false, unique = true)
    private Long quiz_id;

    @NotNull
    @NotEmpty
    @NotBlank
    @Size(min = 1, max = 50)
    @Column(name="quiz_name", length=50, nullable=false, unique=false)
    private String quiz_name;
}
