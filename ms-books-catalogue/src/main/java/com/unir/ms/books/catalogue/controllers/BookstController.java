package com.unir.ms.books.catalogue.controllers;

import com.unir.ms.books.catalogue.services.BooksService;

import java.util.ArrayList;
import java.util.List;

import com.unir.ms.commons.models.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.TimeUnit;

@RestController
public class BookstController {

    @Autowired
    private Environment env;

    @Value("${server.port}")
    private Integer port;
    @Autowired
    private BooksService booksService;

    @GetMapping("/books/list")
    @ResponseStatus(HttpStatus.FOUND)
    public List<Book> bookList(){
        return new ArrayList<>(booksService.findAll());
    }

    @GetMapping("/books/listBooks")
    public ResponseEntity<List<Book>> findAllBooks() {
        return new ResponseEntity<>(booksService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/books/detail/{id}")
    @ResponseStatus(HttpStatus.FOUND)
    public Book bookDetail(@PathVariable Long id) throws InterruptedException {

       if (Long.valueOf(10).equals(id)) {
        throw new IllegalStateException("Book no encontrado");
       }
       if (Long.valueOf(7).equals(id)){
           TimeUnit.SECONDS.sleep(2L);
       }

        Book book = booksService.findById(id);
        return book;
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Book createBook(@RequestBody Book book){
        return booksService.save(book);
    }

    @PutMapping("/edit/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Book editBook(@RequestBody Book book, @PathVariable Long id){
        Book bookDB = booksService.findById(id);
        bookDB.setAuthor(book.getAuthor());
        bookDB.setPrice(book.getPrice());
        bookDB.setTitle(book.getTitle());
        bookDB.setGenre(book.getGenre());
        bookDB.setEditorial(book.getEditorial());
        bookDB.setLanguage(book.getLanguage());
        bookDB.setPages(book.getPages());
        bookDB.setYear(book.getYear());
        bookDB.setDescription(book.getDescription());
        bookDB.setImage(book.getImage());
        bookDB.setCreateAt(book.getCreateAt());

        return booksService.save(bookDB);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        booksService.deleteById(id);
    }

}
