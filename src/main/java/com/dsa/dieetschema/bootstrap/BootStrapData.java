package com.dsa.dieetschema.bootstrap;

import com.dsa.dieetschema.domain.Author;
import com.dsa.dieetschema.domain.Book;
import com.dsa.dieetschema.domain.Publisher;
import com.dsa.dieetschema.repositories.AuthorRepository;
import com.dsa.dieetschema.repositories.BookRepository;
import com.dsa.dieetschema.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.lang.reflect.Array;
import java.util.Arrays;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Publisher publisher = new Publisher();
        publisher.setName("Arjen Bookmaker");
        publisher.setCity("Veendam");
        publisher.setState("GR");
        publisher.setAddresLine1("Jacob van heemskerkstraat 41");
        publisherRepository.save(publisher);


        Author eric = new Author("Eric", "Evans");
        Book booker = new Book("Het boek Titeltje", "12323");
        eric.getBooks().add(booker);
        booker.getAuthors().add(eric);

        booker.setPublisher(publisher);
        publisher.getBooks().add(booker);


        authorRepository.save(eric);
        bookRepository.save(booker);
        publisherRepository.save(publisher);

        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("De koele boek", "342453");

        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        noEJB.setPublisher(publisher);
        publisher.getBooks().add(noEJB);

        authorRepository.save(rod);
        bookRepository.save(noEJB);
        publisherRepository.save(publisher);


        System.out.println("Started in Bootstrap");
        System.out.println("Number of Books: " + bookRepository.count());
        System.out.println("Publisher count: " + publisherRepository.count());





    }
}
