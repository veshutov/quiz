package ru.yandex.bookmate.search.quiz.dto;

import java.util.List;

import lombok.Builder;
import lombok.Data;
import lombok.Value;

import ru.yandex.bookmate.search.quiz.model.QuizCardAnswer;

/**
 * @author veshutov
 **/
@Value
@Builder
public class QuizCardViewDto {
    String question;
    List<QuizCardAnswerViewDto> answers;
}
