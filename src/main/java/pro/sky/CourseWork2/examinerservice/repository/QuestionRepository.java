package pro.sky.CourseWork2.examinerservice.repository;

import pro.sky.CourseWork2.examinerservice.domain.Question;

import java.util.Collection;

public interface QuestionRepository {

    Question add(Question question);
    Question remove(Question question);
    Collection<Question> getAll();
}
