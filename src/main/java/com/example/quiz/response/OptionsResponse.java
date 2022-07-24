package com.example.quiz.response;

import com.example.quiz.customGetters.GetCustomOptions;
import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class OptionsResponse {
    private String message;
    private List<GetCustomOptions> options;
}
