package com.elibrary.app;

import com.elibrary.entities.Book;

public class BookTree {

    private Node<String, Book> head;
    private int size = 0;

    public boolean isEmpty() {
        return head == null;
    }

    public int size() {
        return size;
    }

    public void addBook(Book book) {
        if (isEmpty()) {
            head = new Node<>(book.getTitle(), book);
        } else {
            addNode(head, book);
        }
        size++;
    }

    public Book getBook(String title) {
        if(isEmpty()) {
            return null;
        }
        return getBookRecursive(head, title);
    }

    private Book getBookRecursive(Node<String, Book> node, String title) {
        Book result = null;
        if (node != null) {
            if (node.key.compareToIgnoreCase(title) == 0) {
                return node.value;
            }
            if (title.compareToIgnoreCase(node.key) < 0) {
                result = getBookRecursive(node.left, title);
            } else {
                result = getBookRecursive(node.right, title);
            }
        }
        return result;
    }

    private void addNode(Node<String, Book> node, Book book) {
        if (isForLeft(node, book)) {
            if (node.left == null) {
                node.left = new Node<>(book.getTitle(), book);
            } else {
                addNode(node.left, book);
            }
        } else {
            if (node.right == null) {
                node.right = new Node<>(book.getTitle(), book);
            } else {
                addNode(node.right, book);
            }
        }
    }

    public void preOrderTraversal(Action<Book> action) {
        preOrderTraversal(head, action);
    }

    public void postOrderTraversal(Action<Book> action) {
        postOrderTraversal(head, action);
    }

    public void inOrderTraversal(Action<Book> action) {
        inOrderTraversal(head, action);
    }

    private void inOrderTraversal(Node<String, Book> node, Action<Book> action) {
        if (node != null) {
            inOrderTraversal(node.left, action);
            action.perform(node.value);
            inOrderTraversal(node.right, action);
        }
    }

    private void preOrderTraversal(Node<String, Book> node, Action<Book> action) {
        if (node != null) {
            action.perform(node.value);
            preOrderTraversal(node.left, action);
            preOrderTraversal(node.right, action);
        }
    }

    private void postOrderTraversal(Node<String, Book> node, Action<Book> action) {
        if (node != null) {
            postOrderTraversal(node.left, action);
            postOrderTraversal(node.right, action);
            action.perform(node.value);
        }
    }





    private boolean isForLeft(Node<String, Book> node, Book book) {
        return book.getTitle().compareToIgnoreCase(node.key) < 0;
    }

    private static class Node<K extends Comparable<K>, V> {

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        K key;
        V value;
        Node<K,V> left;
        Node<K,V> right;

    }

}
