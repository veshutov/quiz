package ru.yandex.bookmate.search.quiz.model;

import java.time.Instant;
import java.util.Set;

import com.fasterxml.jackson.databind.JsonNode;
import com.vladmihalcea.hibernate.type.array.ListArrayType;
import com.vladmihalcea.hibernate.type.json.JsonType;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

/**
 * @author veshutov
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "book")
public class Book {
    @Id
    @GeneratedValue
    private Long id;
    private String author;
    private String language;
    @Type(JsonType.class)
    @Column(columnDefinition = "jsonb")
    private JsonNode quote;
    @Type(ListArrayType.class)
    @Column(columnDefinition = "text[]")
    private Set<String> tags;
    private Instant publishedAt;
    private Instant createdAt;
    private Instant updatedAt;
}
