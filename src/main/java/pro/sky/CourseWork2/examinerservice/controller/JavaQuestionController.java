package pro.sky.CourseWork2.examinerservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.CourseWork2.examinerservice.domain.Question;
import pro.sky.CourseWork2.examinerservice.service.JavaQuestionService;

import java.util.Collection;

@RestController
@RequestMapping("/exam/java")
public class JavaQuestionController {
    private final JavaQuestionService javaQuestionService;

    public JavaQuestionController(JavaQuestionService javaQuestionService) {
        this.javaQuestionService = javaQuestionService;
    }

    @GetMapping("/add")

    public Question add(@RequestParam("question") String questionText,
                        @RequestParam("answer") String questionAnswer) {
        return javaQuestionService.add(questionText, questionAnswer);
    }

    @GetMapping("/remove")

    public Question remove(@RequestParam("question") String questionText,
                           @RequestParam("answer") String questionAnswer) {
        return javaQuestionService.remove(questionText, questionAnswer);
    }

    @GetMapping
    public Collection<Question> getAll() {
        return javaQuestionService.getAll();
    }

}
