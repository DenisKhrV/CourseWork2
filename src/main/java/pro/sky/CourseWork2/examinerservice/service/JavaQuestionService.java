package pro.sky.CourseWork2.examinerservice.service;

import org.springframework.stereotype.Service;
import pro.sky.CourseWork2.examinerservice.domain.Question;

import java.util.*;
@Service
public class JavaQuestionService implements QuestionService {
    Set<Question> questions = new HashSet<>();
    @Override
    public Question add(String question, String answer) {
        Question newQuestion = new Question(question, answer);
        questions.add(newQuestion);
        return newQuestion;
    }

    @Override
    public Question add(Question question) {
        questions.add(question);
        return question;
    }

    @Override
    public Question remove(String question, String answer) {
        Question removedQuestion = new Question(question, answer);
        questions.remove(removedQuestion);
        return removedQuestion;
    }

    @Override
    public Collection<Question> getAll() {
        return questions;
    }

    @Override
    public Question getRandomQuestion() {
        int randomIdx = new Random().nextInt(questions.size());
        List<Question> questionList = new ArrayList<>(questions);
        return questionList.get(randomIdx);
    }
}
