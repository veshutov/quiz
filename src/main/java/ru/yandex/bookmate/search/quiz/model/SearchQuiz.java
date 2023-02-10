package ru.yandex.bookmate.search.quiz.model;

import java.util.List;

import com.vladmihalcea.hibernate.type.json.JsonType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

/**
 * @author veshutov
 **/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "search_quiz")
public class SearchQuiz {
    @Id
    @GeneratedValue
    private Long id;
    @Type(JsonType.class)
    @Column(columnDefinition = "jsonb")
    private List<QuizCard> cards;
}
