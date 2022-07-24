package com.example.quiz.repository;

import com.example.quiz.entity.Answers;
import org.springframework.data.repository.CrudRepository;

public interface AnswersRepo extends CrudRepository<Answers, Long> {
}
