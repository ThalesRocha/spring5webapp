package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repository.AuthorRepository;
import guru.springframework.spring5webapp.repository.BookRepository;
import guru.springframework.spring5webapp.repository.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(BookRepository bookRepository, AuthorRepository authorRepository,
            PublisherRepository publisherRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        final Author eric = new Author("Eric", "Evans");
        final Book ddd = new Book("Domain Driven Design", "123123");

        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(ddd);

        final Author rod = new Author("Rod", "Jhonson");
        final Book noEJB = new Book("J2EE Development without EJB", "3939459459");

        rod.getBooks().add(ddd);
        noEJB.getAuthors().add(eric);

        authorRepository.save(rod);
        bookRepository.save(noEJB);

        System.out.println("Started in bootsbtrap");
        System.out.println("Number of books: " + bookRepository.count());
        System.out.println("Number of authors: " + authorRepository.count());

        final Publisher publisher = new Publisher("80 Bay Street", "Sydney", "NSW", "11111", "ezy");
        publisherRepository.save(publisher);

        System.out.println("Number of publishers: " + publisherRepository.count());


    }
}
