package ru.yandex.bookmate.search.quiz.dto;

import java.util.List;

import lombok.Builder;
import lombok.Data;
import lombok.Value;

import ru.yandex.bookmate.search.quiz.model.QuizCard;
import ru.yandex.bookmate.search.quiz.model.SearchQuiz;

/**
 * @author veshutov
 **/
@Value
@Builder
public class QuizViewDto {
    long id;
    List<QuizCardViewDto> cards;

    public static QuizViewDto from(SearchQuiz searchQuiz) {
        return QuizViewDto.builder()
                .id(searchQuiz.getId())
                .cards(searchQuiz.getCards()
                               .stream()
                               .map(c -> QuizCardViewDto.builder()
                                       .question(c.getQuestion())
                                       .answers(c.getAnswers()
                                                        .stream()
                                                        .map(a -> QuizCardAnswerViewDto.builder()
                                                                .label(a.getLabel())
                                                                .build())
                                                        .toList())
                                       .build()).
                               toList())
                .build();
    }
}
