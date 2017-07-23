package com.elibrary.config;

/**
 * Created by nikolay on 23.07.17.
 */
public class TestDatabaseData {

    public static final String INSERT_TO_REWARDS = "Insert into rewards(year, title, author_id) values \n" +
            "(2016, 'Nobel Prize for Literature', 1),\n" +
            "(1933, 'Nobel Prize for Literature', 2),\n" +
            "(1903, 'Pushkin Prize', 2)\n"
            ;

    //mysql date format: 'yyyy-mm-dd' or 'yy-mm-dd'
    public static final String INSERT_TO_AUTHORS = "Insert into authors(\n" +
            "birth_date, first_name, last_name, sex) values\n" +
            "(1941-05-24, 'Bob', 'Dylan', male),\n" +
            "(1870-10-22, 'Ivan', 'Bunin', male),\n"
//            "(22.10.1870, 'Ivan', 'Bunin', male),\n"
            ;

    public static final String INSERT_TO_BOOKS = "Insert into books(\n" +
            "title, ISBN, genre) values \n" +
            "(),\n"
            ;

}
