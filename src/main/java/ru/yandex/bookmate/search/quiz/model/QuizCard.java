package ru.yandex.bookmate.search.quiz.model;

import java.util.List;

import lombok.Data;

/**
 * @author veshutov
 **/
@Data
public class QuizCard {
    private String question;
    private List<QuizCardAnswer> answers;
}
