package com.igladkikh.webflux.controller;

import com.igladkikh.webflux.entity.Book;
import com.igladkikh.webflux.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/books")
@RequiredArgsConstructor
public class BookController {
    private final BookRepository bookRepository;

    @PostMapping
    public Mono<Book> save(@RequestBody Book book) {
        return bookRepository.save(book);
    }

    @GetMapping("/{id}")
    public Mono<Book> findById(@PathVariable String id) {
        return bookRepository.findById(id);
    }

    @GetMapping
    public Flux<Book> findByAll() {
        return bookRepository.findByAll();
    }
}
