package com.example.quiz.controller;

import com.example.quiz.customGetters.GetCustomOptions;
import com.example.quiz.entity.Questions;
import com.example.quiz.entity.Quiz;
import com.example.quiz.request.NameRequest;
import com.example.quiz.response.OptionsResponse;
import com.example.quiz.response.QuestionsResponse;
import com.example.quiz.response.QuizResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class QuizControllerTest {

    @Autowired
    QuizController quizController;

    @Test
    void get_name() {
        NameRequest nameRequest = new NameRequest(1L, "FutureIntent");

        Map<String,String> expected = new HashMap<>();
        expected.put("message", "") ;

        ResponseEntity< Map<String,String> > response = quizController.get_name(nameRequest);

        assertEquals(expected, response.getBody());
    }

    @Test
    void get_tests() {
        ResponseEntity<QuizResponse> response = quizController.get_tests();

        String expectedMessage = "";
        String responseMessage = response.getBody().getMessage();
        List<Quiz> tests = response.getBody().getTests();

        assertEquals(expectedMessage, responseMessage);
        assertTrue(tests.size() > 0);
    }

    @Test
    void get_questions() {
        ResponseEntity<QuestionsResponse> response = quizController.get_questions(1L);

        String expectedMessage = "";
        String responseMessage = response.getBody().getMessage();
        List<Questions> questions = response.getBody().getQuestions();

        assertEquals(expectedMessage, responseMessage);
        assertTrue(questions.size() > 0);
    }

    @Test
    void get_options() {
        ResponseEntity<OptionsResponse> response = quizController.get_options(3L);

        String expectedMessage = "";
        String responseMessage = response.getBody().getMessage();
        List<GetCustomOptions> options = response.getBody().getOptions();

        assertEquals(expectedMessage, responseMessage);
        assertTrue(options.size() > 0);
    }
}