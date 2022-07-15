package com.example.quiz.repository;

import com.example.quiz.custom_getters.GetCustomOptions;
import com.example.quiz.dto.Options;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Options_repo extends CrudRepository<Options, Long> {
    @Query(value = "SELECT op.* from quiz.options op WHERE op.question_id = :question_id", nativeQuery = true)
    List<GetCustomOptions> findQuestionOptions(@Param("question_id") int question_id);
}
