package com.unir.ms.books.catalogue.services.impl;

import com.unir.ms.books.catalogue.models.repositories.BooksRepository;
import com.unir.ms.books.catalogue.services.BooksService;
import com.unir.ms.commons.models.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BooksServiceImpl implements BooksService {

    @Autowired
    private BooksRepository booksRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Book> findAll() {
        return (List<Book>) booksRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Book findById(Long id) {
        return booksRepository.findById(id).orElse(new Book());
    }

    @Override
    @Transactional
    public Book save(Book book) {
        return booksRepository.save(book);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        booksRepository.deleteById(id);
    }
}
