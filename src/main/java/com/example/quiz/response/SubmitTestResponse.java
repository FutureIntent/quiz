package com.example.quiz.response;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class SubmitTestResponse {
    private String name;
    private String message;
    private float score;
}
