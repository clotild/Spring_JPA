package fr.training;

import fr.training.entity.Author;
import fr.training.entity.Book;
import fr.training.entity.BookDetail;
import fr.training.entity.Library;
import fr.training.repository.AuthorRepository;
import fr.training.repository.BookDetailRepository;
import fr.training.repository.BookRepository;
import fr.training.repository.LibraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;

@SpringBootApplication
public class SpringDataJpaApplication implements CommandLineRunner {

    @Autowired
    private LibraryRepository libraryRepository;
    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private BookRepository bookRepository;

    public static void main(String[] args) {
        SpringApplication.run(SpringDataJpaApplication.class, args);
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        System.out.println("Exécuté au lancement du serveur : Pratique pour tester JPA");

        // Insérer auteurs
        Author author1 = new Author("Firstname1" , "Lastname1");
        authorRepository.save(author1);
        Author author2 = new Author("Firstname2" , "Lastname2");
        authorRepository.save(author2);

        // Insérer livres
        Book book1 = new Book("Book1", author1,  new BookDetail("Genre100"));
        bookRepository.save(book1);

        Book book2 = new Book("Book2", author2, new BookDetail("Genre 200"));
        bookRepository.save(book2);

        // Insérer bibliothèques
        Library l1 = new Library("Bibliothèque du Congrès (Washington)", 350000);
        libraryRepository.save(l1);
        Library l2 = new Library("Bibliothèque nationale de Chine (Pékin)", 250000);
        libraryRepository.save(l2);

        book1.setLibraries(Arrays.asList(l1, l2));
        book2.setLibraries(Arrays.asList(l2));
    }
}
