package com.example.quiz.dto;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Date;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Entity(name = "results")
@Table(name = "results",  schema="quiz")
public class Results {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "results_id", updatable = false, unique = true)
    private Long results_id;

    @NotNull(message = "Test id must not be null")
    @Min(value = 0, message = "Test id min value is 0")
    @NonNull
    private Long quiz_id;

    @NotNull(message = "Name must not be null")
    @NotEmpty(message = "Name must not be empty")
    @NotBlank(message = "Name must not be blank")
    @Size(min = 1, max = 50)
    @Column(name = "user_name", updatable = true, unique = false, length = 50, nullable = false)
    @NonNull
    private String user_name;

    @NotNull(message = "Result must be not null")
    @Min(value = 0, message = "Result min value is 0")
    @Max(value = 100, message = "Result max value is 100")
    @Column(name = "result", updatable = false, unique = false, nullable = false)
    @NonNull
    private float result;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "creation_date", updatable = false, nullable = false)
    private Date creation_date;
}
