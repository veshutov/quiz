package ru.yandex.bookmate.search.quiz.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import ru.yandex.bookmate.search.quiz.dao.SearchQuizRepository;
import ru.yandex.bookmate.search.quiz.model.SearchQuiz;

/**
 * @author veshutov
 **/
@Service
@AllArgsConstructor
public class BestSearchQuizSelector {
    private SearchQuizRepository searchQuizRepository;

    /**
     * Выбор конкретного квиза для юзера может зависеть от многих факторов: его предпочтений,
     * экспериментов, истории предыдущих квизов, ранжирования квизов по уровню конверсии в чтение книги и т.д.
     * Здесь для простоты берем 1 попавшийся.
     */
    public SearchQuiz selectBestSearchQuizForUser(Long uid) {
        return searchQuizRepository.findAll().get(0);
    }
}
