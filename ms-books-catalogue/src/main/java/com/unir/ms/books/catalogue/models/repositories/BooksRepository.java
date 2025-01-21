package com.unir.ms.books.catalogue.models.repositories;

import com.unir.ms.commons.models.entity.Book;
import org.springframework.data.repository.CrudRepository;

public interface BooksRepository extends CrudRepository<Book, Long>{

}
