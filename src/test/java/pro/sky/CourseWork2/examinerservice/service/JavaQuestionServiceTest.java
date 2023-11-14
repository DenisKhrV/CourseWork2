package pro.sky.CourseWork2.examinerservice.service;

import org.junit.jupiter.api.Test;
import pro.sky.CourseWork2.examinerservice.domain.Question;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class JavaQuestionServiceTest {
    JavaQuestionService javaQuestionService = new JavaQuestionService();

    @Test
    void add_success() {
        Question exceptionQuestion = new Question("Вопрос", "Ответ");
        String question = "Вопрос";
        String answer = "Ответ";
        Question actualQuestion = javaQuestionService.add(question, answer);
        assertTrue(javaQuestionService.questions.contains(exceptionQuestion));
        assertEquals(exceptionQuestion, actualQuestion);
    }

    @Test
    void testAdd_success() {
        Question exceptionQuestion = new Question("Вопрос", "Ответ");
        Question actualQuestion = javaQuestionService.add(exceptionQuestion);
        assertTrue(javaQuestionService.questions.contains(exceptionQuestion));
        assertEquals(exceptionQuestion, actualQuestion);
    }

    @Test
    void remove_success() {
        Question exceptionQuestion = new Question("Вопрос", "Ответ");
        String question = "Вопрос";
        String answer = "Ответ";
        javaQuestionService.add(question, answer);
        Question actualQuestion = javaQuestionService.remove(question, answer);
        assertFalse(javaQuestionService.questions.contains(exceptionQuestion));
        assertEquals(exceptionQuestion, actualQuestion);
    }

    @Test
    void getAll_success() {
        Question question1 = new Question("Вопрос1", "Ответ1");
        Question question2 = new Question("Вопрос2", "Ответ2");
        Question question3 = new Question("Вопрос3", "Ответ3");
        Set<Question> expectedQuestions = new HashSet<>();
        expectedQuestions.add(question1);
        expectedQuestions.add(question2);
        expectedQuestions.add(question3);
        Set<Question> actualQuestions = (Set<Question>) javaQuestionService.getAll();
        javaQuestionService.add(question1);
        javaQuestionService.add(question2);
        javaQuestionService.add(question3);
        assertEquals(expectedQuestions, actualQuestions);
    }

    @Test
    void getRandomQuestion_success() {
        Question question1 = new Question("Вопрос1", "Ответ1");
        Question question2 = new Question("Вопрос2", "Ответ2");
        Question question3 = new Question("Вопрос3", "Ответ3");
        javaQuestionService.add(question1);
        javaQuestionService.add(question2);
        javaQuestionService.add(question3);
        Question actualQuestion = javaQuestionService.getRandomQuestion();
        assertTrue(actualQuestion.equals(question1) || actualQuestion.equals(question2) || actualQuestion.equals(question3));

    }
}