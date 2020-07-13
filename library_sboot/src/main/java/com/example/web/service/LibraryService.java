package com.example.web.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.web.model.BookModel;


@Service
public class LibraryService {
    private static List<BookModel> books = new ArrayList<BookModel>();
    private static int book_count = 3;

    static {
        books.add(new BookModel(1, "sila", "Jack London","White Fang", new Date()));
        books.add(new BookModel(2, "sila", "Fahrenheit 451","Ray Bradbury", new Date()));
        books.add(new BookModel(3, "sila", "The World of Yesterday","Stefan Zweig", new Date()));
    }

    public List<BookModel> showBooks(String reader) {
        List<BookModel> book_list = new ArrayList<BookModel>();
        for (BookModel book: books) {
            if (book.getReader().equals(reader)) {
                book_list.add(book);
            }
        }
        return book_list;
    }

    public void addBook(String reader, String author, String bookName, Date targetDate) {
        books.add(new BookModel(++book_count, reader, author, bookName, targetDate));
    }

  
}
