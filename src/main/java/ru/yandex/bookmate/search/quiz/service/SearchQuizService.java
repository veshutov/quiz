package ru.yandex.bookmate.search.quiz.service;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import ru.yandex.bookmate.search.quiz.dao.SearchQuizRepository;
import ru.yandex.bookmate.search.quiz.model.Book;
import ru.yandex.bookmate.search.quiz.model.QuizResult;
import ru.yandex.bookmate.search.quiz.model.SearchFilter;
import ru.yandex.bookmate.search.quiz.model.SearchQuiz;

/**
 * @author veshutov
 **/
@Service
@AllArgsConstructor
public class SearchQuizService {
    private final SearchQuizRepository searchQuizRepository;
    private final BestSearchQuizSelector bestSearchQuizSelector;
    private final BookService bookService;

    public List<Book> submitAnswer(Long id, QuizResult quizResult) {
        SearchQuiz quiz = searchQuizRepository.findById(id).orElseThrow();
        ArrayList<SearchFilter> filters = new ArrayList<>();
        List<Integer> answers = quizResult.getAnswers();
        for (int cardIndex = 0; cardIndex < answers.size(); cardIndex++) {
            int selectedAnswerIndex = answers.get(cardIndex);
            SearchFilter filter = quiz.getCards()
                    .get(cardIndex)
                    .getAnswers()
                    .get(selectedAnswerIndex)
                    .getFilter();
            filters.add(filter);
        }
        return bookService.search(filters);
    }

    public SearchQuiz selectBestForUser(Long uid) {
        return bestSearchQuizSelector.selectBestSearchQuizForUser(uid);
    }

    public SearchQuiz save(SearchQuiz searchQuiz) {
        return searchQuizRepository.save(searchQuiz);
    }
}
