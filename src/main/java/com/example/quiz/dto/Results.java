package com.example.quiz.dto;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Date;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "results")
@Table(name = "results",  schema="quiz")
public class Results {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "results_id", updatable = false, unique = true)
    private Long results_id;

    @NotNull
    @NotEmpty
    @NotBlank
    @Size(min = 1, max = 50)
    @Column(name = "user_name", updatable = true, unique = false, length = 50, nullable = false)
    private String user_name;

    @NotNull
    @NotEmpty
    @NotBlank
    @Min(0)
    @Max(100)
    @Column(name = "result", updatable = false, unique = false, nullable = false)
    private float result;

    @Basic
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "creation_date", updatable = false, nullable = false)
    private Date creation_date;
}
