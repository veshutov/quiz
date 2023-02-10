package ru.yandex.bookmate.search.quiz.model;

import lombok.Data;

/**
 * @author veshutov
 **/
@Data
public class QuizCardAnswer {
    private String label;
    private SearchFilter filter;
}
