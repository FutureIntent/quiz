package com.example.quiz.controller;

import com.example.quiz.request.NameRequest;
import com.example.quiz.request.SubmitTestRequest;
import com.example.quiz.response.OptionsResponse;
import com.example.quiz.response.QuestionsResponse;
import com.example.quiz.response.QuizResponse;
import com.example.quiz.response.SubmitTestResponse;
import com.example.quiz.service.QuizService;
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
public class QuizController {

    @Autowired
    QuizService quizService;

    @GetMapping(value = "/tests")
    public ResponseEntity<QuizResponse> get_tests(){

        ResponseEntity<QuizResponse> response = quizService.getTests();

        return response;
    }

    @GetMapping(value="/questions/{quiz_id}")
    public ResponseEntity<QuestionsResponse> get_questions(@PathVariable Long quiz_id){

        ResponseEntity<QuestionsResponse> response = quizService.getQuestions(quiz_id);

        return response;
    }

    @GetMapping(value="/options/{question_id}")
    public ResponseEntity<OptionsResponse> get_options(@PathVariable Long question_id){

        ResponseEntity<OptionsResponse> response = quizService.getOptions(question_id);

        return response;
    }

    @PostMapping(value = "/getName")
    public ResponseEntity get_name(@Valid @RequestBody NameRequest body){

        Map<String,String> message = new HashMap<>();
        message.put("message", "");

        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @PostMapping(value = "/submitTest")
    public ResponseEntity<SubmitTestResponse> submit_test(@Valid @RequestBody SubmitTestRequest body){

        ResponseEntity<SubmitTestResponse> response = quizService.submitTest(body);

        return response;
    }
}
