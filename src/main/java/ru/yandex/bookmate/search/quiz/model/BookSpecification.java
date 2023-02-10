package ru.yandex.bookmate.search.quiz.model;

import java.time.Instant;
import java.util.Collection;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Path;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

/**
 * @author veshutov
 **/
@AllArgsConstructor
public class BookSpecification implements Specification<Book> {
    private final SearchFilter searchFilter;

    @Override
    public Predicate toPredicate(Root<Book> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        Object val = searchFilter.getValue();
        Path<Collection<Object>> collection = root.get(searchFilter.getKey());
        return switch (searchFilter.getOperation()) {
            case EQ -> criteriaBuilder.equal(collection, val);
            case NEQ -> criteriaBuilder.notEqual(collection, val);
            case GTE -> criteriaBuilder.greaterThanOrEqualTo(root.get(searchFilter.getKey()), Instant.parse((String) val));
            case LTE -> criteriaBuilder.lessThanOrEqualTo(root.get(searchFilter.getKey()), Instant.parse((String) val));
        };
    }
}
