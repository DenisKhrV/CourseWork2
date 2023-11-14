package pro.sky.CourseWork2.examinerservice.service;

import org.springframework.stereotype.Service;
import pro.sky.CourseWork2.examinerservice.domain.Question;
import pro.sky.CourseWork2.examinerservice.exceptions.ExaminerServiceException;

import java.util.Collection;
import java.util.HashSet;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    private final QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }
    @Override
    public Collection<Question> getQuestions(int amount) {
        if (amount > questionService.getAll().size()) {
            throw new ExaminerServiceException("Запрошено слишком много вопросов");
        }
        Collection<Question> result = new HashSet<>();
        while (result.size() < amount) {
            result.add(questionService.getRandomQuestion());
        }
        return result;
    }
}
