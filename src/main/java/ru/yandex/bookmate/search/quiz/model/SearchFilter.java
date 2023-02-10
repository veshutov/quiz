package ru.yandex.bookmate.search.quiz.model;

import lombok.Data;
import lombok.Value;

/**
 * @author veshutov
 **/
@Data
public class SearchFilter {
    private String key;
    private Operation operation;
    private Object value;
}
