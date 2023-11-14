package pro.sky.CourseWork2.examinerservice.service;

import pro.sky.CourseWork2.examinerservice.domain.Question;

import java.util.Collection;

public interface ExaminerService {
    Collection<Question> getQuestions(int amount);
}
