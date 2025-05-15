package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.example.model.Author;
import org.example.model.Book;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("library");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        Author author1 = new Author();
        author1.setName("Pero Perić");
        em.persist(author1);

        Author author2 = new Author();
        author2.setName("Iva Ivić");
        em.persist(author2);

        Book book1 = new Book();
        book1.setTitle("Java");
        book1.getAuthors().add(author1);
        book1.getAuthors().add(author2);
        em.persist(book1);

        Book book2 = new Book();
        book2.setTitle("Hibernate");
        book2.getAuthors().add(author2);
        em.persist(book2);

        //Dohvaćanje knjiga
        List<Book> books = em.createQuery("select b from Book b", Book.class).getResultList();
        for (Book b : books) {
            System.out.println("Naslov: " + b.getTitle());
            for (Author a : b.getAuthors()) {
                System.out.println("Authori: " + a.getName());
            }
        }
//        Pronalaženje knjige
        Book book = em.find(Book.class, 1L);
        if (book != null) {
//            Ažuriranje naslova knjige
            book.setTitle("Novi naziv knjige");
        }
        book = em.find(Book.class, 1L);
        System.out.println("Novi naziv: " + book.getTitle());

//        Pronalaženje knjige
        book = em.find(Book.class, 1L);

        if (book != null) {
//            Brisanje knjige
            em.remove(book);
        }

        tx.commit();
        em.close();
        emf.close();


    }
}