package com.example.quiz.response;

import com.example.quiz.entity.Questions;
import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class QuestionsResponse {
    private String message;
    private List<Questions> questions;
}
