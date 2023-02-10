package ru.yandex.bookmate.search.quiz.controller;

import java.util.List;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ru.yandex.bookmate.search.quiz.dto.QuizCreateDto;
import ru.yandex.bookmate.search.quiz.dto.QuizViewDto;
import ru.yandex.bookmate.search.quiz.model.AllowedFilter;
import ru.yandex.bookmate.search.quiz.model.Book;
import ru.yandex.bookmate.search.quiz.model.Operation;
import ru.yandex.bookmate.search.quiz.model.QuizSettings;
import ru.yandex.bookmate.search.quiz.model.QuizResult;
import ru.yandex.bookmate.search.quiz.model.SearchQuiz;
import ru.yandex.bookmate.search.quiz.service.SearchQuizService;

/**
 * @author veshutov
 **/
@AllArgsConstructor
@RestController
@RequestMapping("quiz")
public class SearchQuizController {
    private final SearchQuizService searchQuizService;

    /**
     * @param quizCreateDto – конфигурация квиза, состоящие из карточек с вопросами и вариантами ответа на них
     */
    @PostMapping
    public SearchQuiz create(@RequestBody QuizCreateDto quizCreateDto) {
        return searchQuizService.save(SearchQuiz.builder()
                                              .cards(quizCreateDto.getCards())
                                              .build());
    }

    /**
     * @param uid – уникальный идентификатор пользователя в яндексе
     */
    @GetMapping
    public QuizViewDto getForUser(@RequestParam Long uid) {
        return QuizViewDto.from(searchQuizService.selectBestForUser(uid));
    }

    @PostMapping("{id}/answer")
    public List<Book> submitQuiz(@PathVariable Long id, @RequestBody QuizResult quizResult) {
        return searchQuizService.submitAnswer(id, quizResult);
    }

    @GetMapping("settings")
    public QuizSettings getQuizSettings() {
        return QuizSettings.builder()
                .allowedFilters(List.of(
                        AllowedFilter.builder()
                                .key("author")
                                .allowedOperations(List.of(Operation.EQ, Operation.NEQ))
                                .allowedValues(List.of("shekspir", "dostoevskiy", "remark", "pushkin"))
                                .build(),
                        AllowedFilter.builder()
                                .key("publishedAt")
                                .allowedOperations(List.of(Operation.GTE, Operation.LTE))
                                .allowedValues(List.of(
                                        "2020-01-01T00:00:00.00Z",
                                        "2010-01-01T00:00:00.00Z",
                                        "2000-01-01T00:00:00.00Z",
                                        "1990-01-01T00:00:00.00Z",
                                        "1950-01-01T00:00:00.00Z",
                                        "1900-01-01T00:00:00.00Z",
                                        "1800-01-01T00:00:00.00Z",
                                        "1700-01-01T00:00:00.00Z",
                                        "1600-01-01T00:00:00.00Z"
                                ))
                                .build()
                ))
                .build();
    }
}
