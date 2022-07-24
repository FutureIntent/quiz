package com.example.quiz.entity;

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
@Entity(name = "options")
@Table(name = "options",  schema="quiz")
public class Options {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "option_id", updatable = false, unique = true)
    private Long option_id;

    @NotNull
    @NotEmpty
    @NotBlank
    @Size(min = 1, max = 255)
    @Column(name = "option_text", length = 255, nullable = false, unique = false)
    private String option_text;

    @ManyToOne(optional = false)
    @JoinColumn(name="question_id", referencedColumnName = "question_id")
    private Questions questions;

    @NotNull
    @Column(name = "answer", nullable = false, unique = false)
    private Boolean answer;

}
