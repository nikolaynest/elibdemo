package com.elibrary.config;

/**
 * Created by nikolay on 23.07.17.
 */
class TestDatabaseData {

    //mysql date format: 'yyyy-mm-dd' or 'yy-mm-dd'
    static final String INSERT_TO_AUTHORS = "Insert into authors(\n" +
            "birth_date, first_name, last_name, sex) values\n" +
            "('1941-05-24', 'Bob', 'Dylan', 'male'),\n" +
            "('1897-10-15', 'Ilya', 'Ilf', 'male'),\n" +
            "('1902-12-13', 'Yevgeny', 'Petrov', 'male'),\n" +
            "('1961-03-13', 'Erich', 'Gamma', 'male'),\n" +
            "('1955-07-10', 'Ralph', 'Johnson', 'male'),\n" +
            "('1961-02-08', 'John', 'Vlissides', 'male'),\n" +
            "('1870-10-22', 'Ivan', 'Bunin', 'male')\n"
            ;

    static final String INSERT_TO_REWARDS = "Insert into rewards(year, title, author_id) values \n" +
            "(2016, 'Nobel Prize for Literature', 1),\n" +
            "(1933, 'Nobel Prize for Literature', 2),\n" +
            "(1903, 'Pushkin Prize', 2)\n"
            ;

    static final String INSERT_TO_BOOKS = "Insert into books(\n" +
            "title, ISBN, genre) values \n" +
            "('Title1', 'isbn1', 'genre1'),\n" +
            "('Title2', 'isbn2', 'genre2'),\n" +
            "('Title3', 'isbn3', 'genre3'),\n" +
            "('The Twelve Chairs', 'isbn4', 'novel'),\n" +
            "('The Little Golden Calf', 'isbn5', 'novel'),\n" +
            "('Design Patterns', '0-201-63361-2', 'Programming'),\n" +
            "('Title6', 'isbn6', 'genre6')\n"
            ;

    static final String INSERT_TO_AUTHORS_BOOKS = "Insert into authors_books(\n" +
            "author_id, book_id) values \n" +
            "(1, 1),\n" +
            "(1, 2),\n" +
            "(2, 4),\n" +
            "(3, 4),\n" +
            "(2, 5),\n" +
            "(3, 5),\n" +
            "(4, 6),\n" +
            "(5, 6),\n" +
            "(6, 6)\n"
            ;

}
