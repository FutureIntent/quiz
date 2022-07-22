package com.example.quiz.dto;

import lombok.*;

import javax.persistence.*;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Entity(name = "answers")
@Table(name = "answers",  schema="quiz")
public class Answers {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "answers_id", updatable = false, unique = true)
    private Long answers_id;

    @NonNull
    @ManyToOne(optional = false)
    @JoinColumn(name="results_id", referencedColumnName = "results_id")
    private Results result;

    @NonNull
    @ManyToOne(optional = false)
    @JoinColumn(name="option_id", referencedColumnName = "option_id")
    private Options option;
}
