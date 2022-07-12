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
@Entity(name = "questions")
@Table(name = "questions",  schema="quiz")
public class Questions {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "question_id", updatable = false, unique = true)
    private Long question_id;

    @NotNull
    @NotEmpty
    @NotBlank
    @Size(min = 1, max = 255)
    @Column(name = "question_text", length = 255, nullable = false, unique = false)
    private String question_text;

    @ManyToOne(optional = false)
    @JoinColumn(name="quiz_id", referencedColumnName = "quiz_id")
    private Quiz quiz;
}
