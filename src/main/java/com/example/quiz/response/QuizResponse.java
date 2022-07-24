package com.example.quiz.response;

import com.example.quiz.entity.Quiz;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class QuizResponse {
    private String message;
    private List<Quiz> tests;
}
