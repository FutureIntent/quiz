package com.example.quiz.service;

import com.example.quiz.customGetters.GetCustomOptions;
import com.example.quiz.entity.*;
import com.example.quiz.repository.*;
import com.example.quiz.request.SubmitTestRequest;
import com.example.quiz.response.OptionsResponse;
import com.example.quiz.response.QuestionsResponse;
import com.example.quiz.response.QuizResponse;
import com.example.quiz.response.SubmitTestResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class QuizService {

    @Autowired
    private QuizRepo quizRepo;

    @Autowired
    private QuestionsRepo questionsRepo;

    @Autowired
    private OptionsRepo optionsRepo;

    @Autowired
    private ResultsRepo resultsRepo;

    @Autowired
    private AnswersRepo answersRepo;

    public ResponseEntity<QuizResponse> getTests(){

        List<Quiz> tests = new ArrayList<Quiz>();

        try{
            tests = (List<Quiz>) quizRepo.findAll();
        }catch(Exception e){
            System.out.println(e.getMessage());
            return new ResponseEntity<>(new QuizResponse("Unable to retrieve tests", tests), HttpStatus.BAD_GATEWAY);
        }
        return new ResponseEntity<>(new QuizResponse("", tests), HttpStatus.OK);
    }

    public ResponseEntity<QuestionsResponse> getQuestions(Long quiz_id){

        List<Questions> questions= new ArrayList<Questions>();

        try{
            questions = questionsRepo.findQuizQuestions(quiz_id);
        }catch(Exception e){
            System.out.println(e.getMessage());
            return new ResponseEntity<>(new QuestionsResponse("Unable to retrieve questions", questions), HttpStatus.BAD_GATEWAY);
        }
        return new ResponseEntity<>(new QuestionsResponse("", questions),HttpStatus.OK);
    }

    public ResponseEntity<OptionsResponse> getOptions(Long question_id){

        List<GetCustomOptions> options = new ArrayList<>();

        try{
            options = optionsRepo.findQuestionOptions(question_id);
        }catch(Exception e){
            System.out.println(e.getMessage());
            return new ResponseEntity<>(new OptionsResponse("Unable to retrieve options", options), HttpStatus.BAD_GATEWAY);
        }
        return new ResponseEntity<>(new OptionsResponse("", options), HttpStatus.OK);
    }

    public ResponseEntity<SubmitTestResponse> submitTest(SubmitTestRequest body){

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
            Results stored_result = resultsRepo.save(result);

            questions_answers.forEach((k, v) -> {
                Optional<Options> option = optionsRepo.findById(v);

                if(option.isEmpty()) return;

                Answers answers = new Answers(stored_result, option.get());
                answersRepo.save(answers);
            });

        }catch(Exception e){
            System.out.println(e.getMessage());
            return new ResponseEntity<>(new SubmitTestResponse(name, "Unable to calculate or store result", score), HttpStatus.BAD_GATEWAY);
        }
        return new ResponseEntity<>(new SubmitTestResponse(name, "", score), HttpStatus.OK);
    }
}
