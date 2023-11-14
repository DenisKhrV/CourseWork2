package pro.sky.CourseWork2.examinerservice.service;

import pro.sky.CourseWork2.examinerservice.domain.Question;

import java.util.Collection;

public interface QuestionService {
    Question add(String question, String answer);
    Question add(Question question);
    Question remove(String question, String answer);
    Collection <Question> getAll();
    Question getRandomQuestion();

}
