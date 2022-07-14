package com.example.quiz.controller;

import com.example.quiz.response.Questions_response;
import com.example.quiz.response.Quiz_response;
import com.example.quiz.service.Quiz_service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/quiz")
public class Quiz_controller {

    @Autowired
    Quiz_service quizService;

    @GetMapping(value = "/tests")
    public ResponseEntity<Quiz_response> get_tests(){

        ResponseEntity<Quiz_response> response = quizService.getTests();

        return response;
    }

    @GetMapping(value="/questions/{quiz_id}")
    public ResponseEntity<Questions_response> get_questions(@PathVariable Integer quiz_id){

        ResponseEntity<Questions_response> response = quizService.getQuestions(quiz_id);

        return response;
    }
}
