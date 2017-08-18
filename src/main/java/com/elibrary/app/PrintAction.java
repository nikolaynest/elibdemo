package com.elibrary.app;

import com.elibrary.entities.Book;

public class PrintAction implements Action<Book> {
    @Override
    public void perform(Book book) {
        System.out.println(book.getTitle());
    }
}
