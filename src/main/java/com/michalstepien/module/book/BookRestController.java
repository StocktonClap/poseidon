package com.michalstepien.module.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.PostUpdate;
import java.util.List;

@RestController
public class BookRestController {

    @Autowired
    private BookRepository bookRepository;

    @GetMapping("/api/book")
    public List <BookEntity> getBooks() {
        return bookRepository.findAll();
    }

    @GetMapping("/api/book/{id}")
    public BookEntity getBook(@PathVariable Long id) {
    return bookRepository.findOneById(id);
    }

    @PostMapping("/api/book")
    public BookEntity newBook (@RequestBody BookEntity bookEntity) {
        return bookRepository.saveAndFlush(bookEntity);
    }

    @DeleteMapping("/api/book/{id}")
    public void deleteBooks(@PathVariable Long id) {
        bookRepository.deleteById(id);
    }

    @PutMapping("/api/book/{id}")
    public BookEntity updateBooks(@PathVariable Long id,
                                  @RequestBody BookEntity booksEntity) {
        return bookRepository.saveAndFlush(booksEntity.setId(id));
    }
}
