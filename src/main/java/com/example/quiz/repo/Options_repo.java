package com.example.quiz.repo;

import com.example.quiz.dto.Options;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Options_repo extends CrudRepository<Options, Long> {

}
