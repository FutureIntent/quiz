package com.example.quiz.response;

import com.example.quiz.custom_getters.GetCustomOptions;
import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Options_response {
    private String message;
    private List<GetCustomOptions> options;
}
