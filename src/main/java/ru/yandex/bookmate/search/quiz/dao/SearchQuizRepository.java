package ru.yandex.bookmate.search.quiz.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ru.yandex.bookmate.search.quiz.model.SearchQuiz;

/**
 * @author veshutov
 **/
@Repository
public interface SearchQuizRepository extends JpaRepository<SearchQuiz, Long> {
}
