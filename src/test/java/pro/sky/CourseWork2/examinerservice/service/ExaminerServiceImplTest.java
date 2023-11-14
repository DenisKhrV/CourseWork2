package pro.sky.CourseWork2.examinerservice.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.CourseWork2.examinerservice.domain.Question;
import pro.sky.CourseWork2.examinerservice.exceptions.ExaminerServiceException;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ExaminerServiceImplTest {
    @Mock
    private JavaQuestionService javaQuestionService;

    @InjectMocks
    private ExaminerServiceImpl examinerService;
    @Test
    void getQuestions_success() {
        Question question1 = new Question("Вопрос1", "Ответ1");
        Question question2 = new Question("Вопрос2", "Ответ2");
        Question question3 = new Question("Вопрос3", "Ответ3");
        Set<Question> expectedSet = new HashSet<>();
        expectedSet.add(question1);
        expectedSet.add(question2);
        expectedSet.add(question3);
        when(javaQuestionService.getAll()).thenReturn(expectedSet);
        when(javaQuestionService.getRandomQuestion()).thenReturn(question1, question3);
        Set<Question> actualSet = (Set<Question>) examinerService.getQuestions(2);
        assertTrue(actualSet.contains(question1)&actualSet.contains(question3));

    }
    @Test
    void getQuestions_shouldReturnExaminerServiceException() {
        Question question1 = new Question("Вопрос1", "Ответ1");
        Set<Question> questions = new HashSet<>();
        questions.add(question1);
        when(javaQuestionService.getAll()).thenReturn(questions);
        assertThrows(ExaminerServiceException.class,
                () -> examinerService.getQuestions(2));
    }
}