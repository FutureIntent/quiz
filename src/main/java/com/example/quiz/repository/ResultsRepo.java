package com.example.quiz.repository;

import com.example.quiz.entity.Results;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResultsRepo extends CrudRepository<Results, Long> {

}
