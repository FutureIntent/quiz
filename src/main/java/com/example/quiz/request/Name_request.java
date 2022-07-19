package com.example.quiz.request;

import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Name_request {

    @NotNull(message = "Test id must not be null")
    @Min(value = 0, message = "Test id min value is 0")
    private Long quiz_id;

    @NotNull(message = "Name must not be null")
    @NotEmpty(message = "Name must not be empty")
    @NotBlank(message = "Name must not be blank")
    @Length(min = 1, max = 50, message = "Name length must be 1 to 50 characters long")
    private String name;
}
