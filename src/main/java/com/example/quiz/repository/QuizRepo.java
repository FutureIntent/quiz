package com.example.quiz.repository;

import com.example.quiz.entity.Quiz;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuizRepo extends CrudRepository<Quiz, Long> {

}
