package com.example.quiz.service;

import com.example.quiz.dto.Questions;
import com.example.quiz.dto.Quiz;
import com.example.quiz.repository.Questions_repo;
import com.example.quiz.repository.Quiz_repo;
import com.example.quiz.response.Questions_response;
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

    @Autowired
    private Questions_repo questionsRepo;

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

    public ResponseEntity<Questions_response> getQuestions(int quiz_id){

        List<Questions> questions= new ArrayList<Questions>();

        try{
            questions = questionsRepo.findQuizQuestions(quiz_id);
        }catch(Exception e){
            System.out.println(e.getMessage());
            return new ResponseEntity<>(new Questions_response("Unable to retrieve questions", questions), HttpStatus.BAD_GATEWAY);
        }
        return new ResponseEntity<>(new Questions_response(Integer.toString(quiz_id),questions),HttpStatus.OK);
    }

}
