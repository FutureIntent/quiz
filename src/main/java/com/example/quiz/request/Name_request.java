package com.example.quiz.request;

import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Name_request {

    @NotBlank
    @NotEmpty
    @NotNull
    @Length(min = 1, max = 50)
    private String name;
}
