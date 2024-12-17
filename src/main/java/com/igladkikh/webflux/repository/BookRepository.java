package com.igladkikh.webflux.repository;

import com.igladkikh.webflux.entity.Book;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class BookRepository {
    private final Map<String, Book> bookRepository = new ConcurrentHashMap<>();

    @PostConstruct
    void init() {
        bookRepository.put("1", new Book("1", "Му-му", "И.С. Тургенев"));
        bookRepository.put("2", new Book("2", "Война и мир", "Л.Н. Толстой"));
    }

    public Mono<Book> save(Book book) {
        bookRepository.put(book.getId(), book);
        return Mono.just(book);
    }

    public Mono<Book> findById(String id) {
        return Mono.just(bookRepository.get(id));
    }

    public Flux<Book> findBAll() {
        return Flux.fromIterable(bookRepository.values());
    }
}
