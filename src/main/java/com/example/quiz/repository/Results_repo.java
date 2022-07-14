package com.example.quiz.repository;

import com.example.quiz.dto.Results;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Results_repo extends CrudRepository<Results, Long> {

}
