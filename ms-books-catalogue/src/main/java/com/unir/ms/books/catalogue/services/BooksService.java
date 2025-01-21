package com.unir.ms.books.catalogue.services;


import com.unir.ms.commons.models.entity.Book;
import java.util.List;

public interface BooksService {

    List<Book> findAll();
    Book findById(Long id);
    Book save (Book book);
    void deleteById(Long id);


}
