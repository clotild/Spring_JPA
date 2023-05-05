package fr.training.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "books_id")
    private Long id;

    private String title;

    @ManyToOne
    @JoinColumn(name = "author_fk")
    private Author author;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "book_detail_fk")
    private BookDetail bookDetail;

    @ManyToMany
    @JoinTable(name = "library_book", joinColumns = @JoinColumn(name = "library_id"), inverseJoinColumns = @JoinColumn(name = "book_id"))
    private List<Library> libraries;

    public Book() {
    }

    public Book(String title, Author author, BookDetail bookDetail) {
        this.title = title;
        this.author = author;
        this.bookDetail = bookDetail;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BookDetail getBookDetail() {
        return bookDetail;
    }

    public void setBookDetail(BookDetail bookDetail) {
        this.bookDetail = bookDetail;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public List<Library> getLibraries() {
        return libraries;
    }

    public void setLibraries(List<Library> libraries) {
        this.libraries = libraries;
    }
}
