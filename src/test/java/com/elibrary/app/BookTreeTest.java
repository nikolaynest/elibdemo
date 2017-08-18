package com.elibrary.app;

import com.elibrary.entities.Book;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

public class BookTreeTest {

    private BookTree tree;
    private PrintAction printAction;



    @Before
    public void createTree() {
        printAction = new PrintAction();
        tree = new BookTree();
        Book[] books = generateBooks();
        for (Book book : books) {
            tree.addBook(book);
        }
    }

    @Test
    public void testIsEmpty() {
        assertFalse(tree.isEmpty());
    }



    @Test
    public void addToTree() {
        System.out.println("InOrder Traversal:");
        tree.inOrderTraversal(printAction);
        System.out.println("PreOrder Traversal:");
        tree.preOrderTraversal(printAction);
        System.out.println("PostOrder Traversal:");
        tree.postOrderTraversal(printAction);
    }


    @Test
    public void getBookTest() {
        Book book = tree.getBook("9");
        assertNotNull(book);
    }

    private Book[] generateBooks() {
        String[] titles = new String[] {"5", "2", "6", "8", "1", "9", "3"};
        Book[] books = new Book[titles.length];
        for (int i = 0; i < titles.length; i++) {
            Book book = new Book();
            book.setTitle(titles[i]);
            books[i] = book;
        }
        return books;
    }

}
