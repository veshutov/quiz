package ru.yandex.bookmate.search.quiz.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ru.yandex.bookmate.search.quiz.model.Book;
import ru.yandex.bookmate.search.quiz.service.BookService;

/**
 * @author veshutov
 **/
@AllArgsConstructor
@RestController
@RequestMapping("books")
public class BookController {
    private final BookService bookService;

    @PostMapping
    public Book create(@RequestBody Book book) {
        return bookService.create(book);
    }

    @GetMapping("{id}")
    public Book getById(@PathVariable Long id) {
        return bookService.getById(id);
    }
}
