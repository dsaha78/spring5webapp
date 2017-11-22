package deba.guru.springframework.spring5webapp.repository;

import org.springframework.data.repository.CrudRepository;

import deba.guru.springframework.spring5webapp.model.Author;

public interface AuthorRepogitory extends CrudRepository<Author, Long>{

}
