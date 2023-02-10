package ru.yandex.bookmate.search.quiz.dto;

import lombok.Builder;
import lombok.Value;

/**
 * @author veshutov
 **/
@Value
@Builder
public class QuizCardAnswerViewDto {
    String label;
}
