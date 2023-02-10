package ru.yandex.bookmate.search.quiz.service;

import java.util.List;

import lombok.AllArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import ru.yandex.bookmate.search.quiz.dao.BookRepository;
import ru.yandex.bookmate.search.quiz.model.Book;
import ru.yandex.bookmate.search.quiz.model.BookSpecification;
import ru.yandex.bookmate.search.quiz.model.SearchFilter;

/**
 * @author veshutov
 **/
@Service
@AllArgsConstructor
public class BookService {
    private BookRepository bookRepository;

    public Book create(Book book) {
        return bookRepository.save(book);
    }

    public Book getById(Long id) {
        return bookRepository.findById(id).orElseThrow();
    }

    public List<Book> search(List<SearchFilter> filters) {
        if (filters.isEmpty()) {
            return bookRepository.findAll();
        }

        Specification<Book> specification = buildSpecification(filters);
        return bookRepository.findAll(specification);
    }

    private static Specification<Book> buildSpecification(List<SearchFilter> filters) {
        Specification<Book> specification = filters.stream()
                .map(searchFilter -> (Specification<Book>) new BookSpecification(searchFilter))
                .reduce(Specification::and)
                .orElseThrow();
        return specification;
    }
}
