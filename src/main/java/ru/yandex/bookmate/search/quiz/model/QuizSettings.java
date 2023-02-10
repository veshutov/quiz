package ru.yandex.bookmate.search.quiz.model;

import java.util.List;

import lombok.Builder;
import lombok.Value;

/**
 * @author veshutov
 **/
@Builder
@Value
public class QuizSettings {
    List<AllowedFilter> allowedFilters;
}
