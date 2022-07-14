package com.example.quiz.response;

import com.example.quiz.dto.Questions;
import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Questions_response {
    private String message;
    private List<Questions> questions;
}
