package ru.yandex.bookmate.search.quiz.model;

import java.util.List;

import lombok.Builder;
import lombok.Value;

/**
 * @author veshutov
 **/
@Value
@Builder
public class AllowedFilter {
    String key;
    List<Operation> allowedOperations;
    List<Object> allowedValues;
}
