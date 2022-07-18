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
    List<GetCustomOptions> findQuestionOptions(@Param("question_id") Long question_id);

    @Query(value = "SELECT op.* from quiz.options op WHERE option_id = :option_id AND question_id = :question_id AND answer = true", nativeQuery = true)
    Options checkGivenAnswer(@Param("question_id") Long question_id, @Param("option_id") Long option_id);
}
