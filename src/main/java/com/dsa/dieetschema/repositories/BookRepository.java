package com.dsa.dieetschema.repositories;

import com.dsa.dieetschema.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
