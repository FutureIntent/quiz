package com.example.quiz.response;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class SubmitTest_response {
    private String name;
    private String message;
    private float score;
}
