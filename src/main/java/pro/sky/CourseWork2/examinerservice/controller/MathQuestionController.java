package pro.sky.CourseWork2.examinerservice.controller;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.CourseWork2.examinerservice.domain.Question;
import pro.sky.CourseWork2.examinerservice.service.QuestionService;

import java.util.Collection;

@RestController
@RequestMapping("/exam/math")
public class MathQuestionController {
    private final QuestionService questionService;

    public MathQuestionController(@Qualifier("mathQuestionService") QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping("/add")

    public Question add(@RequestParam("question") String questionText,
                        @RequestParam("answer") String questionAnswer) {
        return questionService.add(questionText, questionAnswer);
    }

    @GetMapping("/remove")

    public Question remove(@RequestParam("question") String questionText,
                           @RequestParam("answer") String questionAnswer) {
        return questionService.remove(questionText, questionAnswer);
    }

    @GetMapping
    public Collection<Question> getAll() {
        return questionService.getAll();
    }
}
