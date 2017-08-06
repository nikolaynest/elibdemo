mysql -u root -p
password> root
show databases;
use BookCatalogDB;
show tables;
describe <table_name>;
------------------------------------------------------------------------------
[CONSTRAINT symbol] FOREIGN KEY (index_col_name, ...)
				      REFERENCES table_name (index_col_name, ...)
				      [ON DELETE CASCADE | ON DELETE SET NULL]

Если указано выражение ON DELETE CASCADE и строка в родительской таблице удалена, то в формате InnoDB все эти строки автоматически удаляются также и из дочерней таблицы, значения внешнего ключа которой равны значениям ссылочного ключа в строке родительской таблицы. Если указано выражение ON DELETE SET NULL, строки дочерней таблицы автоматически обновляются, поэтому столбцам во внешнем ключе также присваивается значение SQL NULL.

---------------------------------------------------------------------
-- Структура таблиц следующая: authors, books, rewards (награды автора), authors_books - many to many relationship
-- Rules:
-- add author: просто добавляем Автора в authors
-- add reward: должна быть запись в authors
-- add book: должна быть запись в authors (книга не может быть без автора:)); добавляем запись и в books и в authors_books;
-- delete author: каскадно удаляем из authors_books, rewards
-- delete books: только если нет записи в authors_books


drop table if exists authors;
drop table if exists books_authors;
drop table if exists authors_books;
drop table if exists rewards;
drop table if exists books;

create table authors (
                author_id bigint not null auto_increment,
                birth_date datetime,
                first_name varchar(255),
                last_name varchar(255),
                sex varchar(10),
                primary key (author_id)
            );

create table rewards (
                reward_id bigint not null auto_increment,
                title varchar(255),
                year integer not null,
                author_id bigint not null,
                primary key (reward_id),
                constraint foreign key (author_id) references authors (author_id)
                on delete cascade on update cascade
                );

create table books (
                book_id bigint not null auto_increment,
                isbn varchar(255),
                genre varchar(50),
                title varchar(255),
                primary key (book_id)
                );

create table authors_books (
                author_id bigint not null,
                book_id bigint not null,
                primary key (author_id, book_id),
                constraint foreign key (book_id) references books (book_id),
                constraint foreign key (author_id) references authors (author_id)
                on delete cascade on update cascade --каскадное удаление и обновление: когда автор удаляется - удаляется запись из authors_books;
                );


--alter table books_authors
--                    add constraint foreign key (book_id)
--                    references books (book_id)
--            ,
--            alter table books_authors
--                    add constraint foreign key (author_id)
--                    references authors (author_id)
--                    on delete cascade on update cascade
--            ,
--            alter table rewards
--                    add constraint foreign key (author_id)
--                    references authors (author_id)
--                    on delete cascade on update cascade

