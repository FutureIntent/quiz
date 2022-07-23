package com.example.quiz.controller;

import com.example.quiz.request.Name_request;
import com.example.quiz.request.SubmitTest_request;
import com.example.quiz.response.Options_response;
import com.example.quiz.response.Questions_response;
import com.example.quiz.response.Quiz_response;
import com.example.quiz.response.SubmitTest_response;
import com.example.quiz.service.Quiz_service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

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
    public ResponseEntity<Questions_response> get_questions(@PathVariable Long quiz_id){

        ResponseEntity<Questions_response> response = quizService.getQuestions(quiz_id);

        return response;
    }

    @GetMapping(value="/options/{question_id}")
    public ResponseEntity<Options_response> get_options(@PathVariable Long question_id){

        ResponseEntity<Options_response> response = quizService.getOptions(question_id);

        return response;
    }

    @PostMapping(value = "/getName")
    public ResponseEntity get_name(@Valid @RequestBody Name_request body){

        Map<String,String> message = new HashMap<>();
        message.put("message", "");

        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @PostMapping(value = "/submitTest")
    public ResponseEntity<SubmitTest_response> submit_test(@Valid @RequestBody SubmitTest_request body){

        ResponseEntity<SubmitTest_response> response = quizService.submitTest(body);

        return response;
    }
}
