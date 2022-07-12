package com.example.quiz.service;

import com.example.quiz.dto.Quiz;
import com.example.quiz.repo.Quiz_repo;
import com.example.quiz.response.Quiz_response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Quiz_service {

    @Autowired
    private Quiz_repo quizRepo;

    public ResponseEntity<Quiz_response> getTests(){

        List<Quiz> tests = new ArrayList<Quiz>();

        try{
            tests = (List<Quiz>) quizRepo.findAll();
        }catch(Exception e){
            System.out.println(e.getMessage());
            return new ResponseEntity<>(new Quiz_response("Unable to retrieve tests", tests), HttpStatus.BAD_GATEWAY);
        }
        return new ResponseEntity<>(new Quiz_response("Success", tests), HttpStatus.OK);
    }

}
