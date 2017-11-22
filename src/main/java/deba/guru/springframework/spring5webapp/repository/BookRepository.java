package deba.guru.springframework.spring5webapp.repository;

import org.springframework.data.repository.CrudRepository;

import deba.guru.springframework.spring5webapp.model.Book;

public interface BookRepository extends CrudRepository<Book, Long> {

}
