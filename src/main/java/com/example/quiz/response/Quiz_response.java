package com.example.quiz.response;

import com.example.quiz.dto.Quiz;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Quiz_response {
    private String message;
    private List<Quiz> tests;
}
