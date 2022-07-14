package com.example.quiz.repository;

import com.example.quiz.dto.Questions;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Questions_repo extends CrudRepository<Questions, Long> {
    @Query(value = "SELECT * from quiz.questions qe WHERE qe.quiz_id = :quiz_id", nativeQuery = true)
    List<Questions> findQuizQuestions(@Param("quiz_id") int quiz_id);
}
