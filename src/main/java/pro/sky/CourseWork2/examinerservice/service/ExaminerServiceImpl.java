package pro.sky.CourseWork2.examinerservice.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import pro.sky.CourseWork2.examinerservice.domain.Question;
import pro.sky.CourseWork2.examinerservice.exceptions.ExaminerServiceException;

import java.util.Collection;
import java.util.HashSet;
import java.util.Random;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    private final QuestionService javaQuestionService;
    private final QuestionService mathQuestionService;

    public ExaminerServiceImpl(@Qualifier("javaQuestionService") QuestionService javaQuestionService,
                               @Qualifier("mathQuestionService") QuestionService mathQuestionService) {
        this.javaQuestionService = javaQuestionService;
        this.mathQuestionService = mathQuestionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        if (amount > (javaQuestionService.getAll().size()) + mathQuestionService.getAll().size()) {
            throw new ExaminerServiceException("Запрошено слишком много вопросов");
        }
        Collection<Question> result = new HashSet<>();
        while (result.size() < amount) {
            boolean serviceIdx = new Random().nextBoolean();
            if (serviceIdx) {
                result.add(javaQuestionService.getRandomQuestion());
            } else {
                result.add(mathQuestionService.getRandomQuestion());
            }
        }
        return result;
    }
}
