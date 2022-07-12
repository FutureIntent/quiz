package com.example.quiz.repo;

import com.example.quiz.dto.Questions;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Questions_repo extends CrudRepository<Questions, Long> {

}
