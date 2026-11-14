package com.library;

import java.util.Arrays;
import java.util.Comparator;

public class LibraryService {

    public Book[] getBooksByAuthor(Book[] books, String author) {
        Book[] temp = new Book[books.length];
        int count = 0;

        for (Book book : books) {
            if (book.getAuthor().equalsIgnoreCase(author.trim())) {
                temp[count++] = book;
            }
        }
        return Arrays.copyOf(temp, count);
    }

    public Book[] getBooksByPublisher(Book[] books, String publisher) {
        Book[] temp = new Book[books.length];
        int count = 0;

        for (Book book : books) {
            if (book.getPublisher().equalsIgnoreCase(publisher.trim())) {
                temp[count++] = book;
            }
        }
        return Arrays.copyOf(temp, count);
    }

    public Book[] getBooksAfterYear(Book[] books, int year) {
        Book[] temp = new Book[books.length];
        int count = 0;

        for (Book book : books) {
            if (book.getYear() > year) {
                temp[count++] = book;
            }
        }
        return Arrays.copyOf(temp, count);
    }

    public Book[] sortBooksByPublisher(Book[] books) {
        Book[] sortedBooks = Arrays.copyOf(books, books.length);
        Arrays.sort(sortedBooks, new Comparator<Book>() {
            @Override
            public int compare(Book b1, Book b2) {
                return b1.getPublisher().compareToIgnoreCase(b2.getPublisher());
            }
        });
        return sortedBooks;
    }
}
