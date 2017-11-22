package deba.guru.springframework.spring5webapp;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import deba.guru.springframework.spring5webapp.model.Author;
import deba.guru.springframework.spring5webapp.model.Book;
import deba.guru.springframework.spring5webapp.model.Publisher;
import deba.guru.springframework.spring5webapp.repository.AuthorRepogitory;
import deba.guru.springframework.spring5webapp.repository.BookRepository;
import deba.guru.springframework.spring5webapp.repository.PublisherRepository;

@Component
public class DevBootStrap implements ApplicationListener<ContextRefreshedEvent> {

	private BookRepository bookRepository;
	private AuthorRepogitory authorRepogitory;
	private PublisherRepository publisherRepository;

	public DevBootStrap(BookRepository bookRepository, AuthorRepogitory authorRepogitory,
			PublisherRepository publisherRepository) {
		super();
		this.bookRepository = bookRepository;
		this.authorRepogitory = authorRepogitory;
		this.publisherRepository = publisherRepository;
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent arg0) {
		initData();
	}

	private void initData() {

		Author eric = new Author("Eric", "Evans");
		Publisher publisher = new Publisher("Wrox", "India");
		Book domain = new Book("Domain Driven Design", "23456", publisher);
		eric.getBooks().add(domain);
		domain.getAuthors().add(eric);
		publisherRepository.save(publisher);
		authorRepogitory.save(eric);
		bookRepository.save(domain);

		Author eric1 = new Author("Rod", "Jhonson");
		Publisher publisher1 = new Publisher("Wrox Pub", "India");
		Book domain1 = new Book("J2EE development", "123456", publisher1);
		eric.getBooks().add(domain1);
		// domain.getAuthors().add(eric1);
		publisherRepository.save(publisher1);
		authorRepogitory.save(eric1);
		bookRepository.save(domain1);
	}
}
