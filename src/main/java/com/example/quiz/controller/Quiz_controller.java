package com.example.quiz.controller;

import com.example.quiz.response.Quiz_response;
import com.example.quiz.service.Quiz_service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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
}
