package com.example.quiz.service;

import com.example.quiz.custom_getters.GetCustomOptions;
import com.example.quiz.dto.Options;
import com.example.quiz.dto.Questions;
import com.example.quiz.dto.Quiz;
import com.example.quiz.dto.Results;
import com.example.quiz.repository.Options_repo;
import com.example.quiz.repository.Questions_repo;
import com.example.quiz.repository.Quiz_repo;
import com.example.quiz.repository.Results_repo;
import com.example.quiz.request.SubmitTest_request;
import com.example.quiz.response.Options_response;
import com.example.quiz.response.Questions_response;
import com.example.quiz.response.Quiz_response;
import com.example.quiz.response.SubmitTest_response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class Quiz_service {

    @Autowired
    private Quiz_repo quizRepo;

    @Autowired
    private Questions_repo questionsRepo;

    @Autowired
    private Options_repo optionsRepo;

    @Autowired
    Results_repo resultsRepo;

    public ResponseEntity<Quiz_response> getTests(){

        List<Quiz> tests = new ArrayList<Quiz>();

        try{
            tests = (List<Quiz>) quizRepo.findAll();
        }catch(Exception e){
            System.out.println(e.getMessage());
            return new ResponseEntity<>(new Quiz_response("Unable to retrieve tests", tests), HttpStatus.BAD_GATEWAY);
        }
        return new ResponseEntity<>(new Quiz_response(null, tests), HttpStatus.OK);
    }

    public ResponseEntity<Questions_response> getQuestions(Long quiz_id){

        List<Questions> questions= new ArrayList<Questions>();

        try{
            questions = questionsRepo.findQuizQuestions(quiz_id);
        }catch(Exception e){
            System.out.println(e.getMessage());
            return new ResponseEntity<>(new Questions_response("Unable to retrieve questions", questions), HttpStatus.BAD_GATEWAY);
        }
        return new ResponseEntity<>(new Questions_response(null, questions),HttpStatus.OK);
    }

    public ResponseEntity<Options_response> getOptions(Long question_id){

        List<GetCustomOptions> options = new ArrayList<>();

        try{
            options = optionsRepo.findQuestionOptions(question_id);
        }catch(Exception e){
            System.out.println(e.getMessage());
            return new ResponseEntity<>(new Options_response("Unable to retrieve options", options), HttpStatus.BAD_GATEWAY);
        }
        return new ResponseEntity<>(new Options_response(null, options), HttpStatus.OK);
    }

    public ResponseEntity<SubmitTest_response> submitTest(SubmitTest_request body){

        String name = body.getName();
        Long quiz_id = body.getTest_id();
        Map<Long, Long> questions_answers = body.getQuestions_options();

        AtomicInteger correct_answers = new AtomicInteger();
        int question_amount = questions_answers.size();
        float score = 0;

        questions_answers.forEach((k, v) -> {
            Options answer = new Options();
            answer = optionsRepo.checkGivenAnswer(k, v);
            if(answer != null) correct_answers.getAndIncrement();
        });

        score = (float) 100 / (float) question_amount * correct_answers.floatValue();

        Results result = new Results(quiz_id, name, score);

        try{
            resultsRepo.save(result);
        }catch(Exception e){
            System.out.println(e.getMessage());
            return new ResponseEntity<>(new SubmitTest_response(name, "Unable to calculate or store result", score), HttpStatus.BAD_GATEWAY);
        }
        return new ResponseEntity<>(new SubmitTest_response(name, null, score), HttpStatus.OK);
    }
}
