package pro.sky.CourseWork2.examinerservice.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import pro.sky.CourseWork2.examinerservice.domain.Question;
import pro.sky.CourseWork2.examinerservice.repository.QuestionRepository;

import java.util.*;

@Service
public class MathQuestionService implements QuestionService {
    private final QuestionRepository questionRepository;

    public MathQuestionService(@Qualifier("mathQuestionRepository") QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @Override
    public Question add(String question, String answer) {
        Question newQuestion = new Question(question, answer);
        questionRepository.add(newQuestion);
        return newQuestion;
    }

    @Override
    public Question add(Question question) {
        questionRepository.add(question);
        return question;
    }

    @Override
    public Question remove(String question, String answer) {
        Question questionForRemove = new Question(question, answer);
        questionRepository.remove(questionForRemove);
        return questionForRemove;
    }

    @Override
    public Collection<Question> getAll() {
        return questionRepository.getAll();
    }

    @Override
    public Question getRandomQuestion() {
        Collection<Question> questions = questionRepository.getAll();
        int randomIdx = new Random().nextInt(questions.size());
        List<Question> questionList = new ArrayList<>(questions);
        return questionList.get(randomIdx);
    }
}
