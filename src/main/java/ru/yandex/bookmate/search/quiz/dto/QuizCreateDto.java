package ru.yandex.bookmate.search.quiz.dto;

import java.util.List;

import lombok.Data;

import ru.yandex.bookmate.search.quiz.model.QuizCard;

/**
 * @author veshutov
 **/
@Data
public class QuizCreateDto {
    private List<QuizCard> cards;
}
