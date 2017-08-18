package com.elibrary.app;

public interface Action<T> {

    void perform(T t);
}
