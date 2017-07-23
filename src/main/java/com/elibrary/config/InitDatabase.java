package com.elibrary.config;

import org.hibernate.tool.hbm2ddl.ConnectionHelper;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.hibernate.tool.hbm2ddl.Target;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.web.authentication.AbstractAuthenticationTargetUrlRequestHandler;

import javax.persistence.EntityManagerFactory;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by nikolay on 23.07.17.
 */

@PropertySource(value = {"classpath:application.properties"})
public class InitDatabase implements BeanPostProcessor {
    private String[] dropSql = new String[]{
            "drop table if exists books_authors",
            "drop table if exists authors_books",
            "drop table if exists authors",
            "drop table if exists rewards",
            "drop table if exists books",
    };
    private String[] createSql = new String[] {
            " create table authors (\n" +
                    "        author_id bigint not null auto_increment,\n" +
                    "        birth_date datetime,\n" +
                    "        first_name varchar(255),\n" +
                    "        last_name varchar(255),\n" +
                    "        sex integer,\n" +
//                    "        reward_id_fk bigint,\n" +
                    "        primary key (author_id)\n" +
                    "    )",
            "create table books (\n" +
                    "        book_id bigint not null auto_increment,\n" +
                    "        isbn varchar(255),\n" +
                    "        genre integer,\n" +
                    "        title varchar(255),\n" +
                    "        primary key (book_id)\n" +
                    "    )",
            "create table books_authors (\n" +
                    "        author_id bigint not null,\n" +
                    "        book_id bigint not null,\n" +
                    "        primary key (author_id, book_id)" +
                    "    )",
            " create table rewards (\n" +
                    "        reward_id bigint not null auto_increment,\n" +
                    "        title varchar(255),\n" +
                    "        year integer not null,\n" +
                    "        author_id bigint not null,\n" +
                    "        primary key (reward_id)\n" +
                    "    )",
//            "alter table authors \n" +
//                    "        add constraint FKb5aarh92o34551s1y2ndelt8m \n" +
//                    "        foreign key (reward_id_fk) \n" +
//                    "        references rewards (reward_id)\n" +
//                    "        on delete no action\n",
            "alter table books_authors \n" +
                    "add constraint foreign key (book_id)\n" +
                    "references books (book_id)"
            ,
            "alter table books_authors \n" +
                    "add constraint foreign key (author_id)\n" +
                    "references authors (author_id)\n" +
                    "on delete cascade"
            ,
            "alter table rewards \n" +
//                    "add column author_id bigint\n" +
                    "add constraint foreign key (author_id)\n" +
                    "references authors (author_id)\n" +
                    "on delete cascade"
            ,
            TestDatabaseData.INSERT_TO_AUTHORS,
            TestDatabaseData.INSERT_TO_REWARDS

    };

    @Value("${spring.datasource.url}")
    private String url;

    @Value("${spring.datasource.username}")
    private String userName;

    @Value("${spring.datasource.password}")
    private String password;

    @Override
    public Object postProcessBeforeInitialization(Object o, String s) throws BeansException {
        if (o instanceof EntityManagerFactory) {
            System.out.println("Before EntityManagerFactory Initialization");
        }
        return o;
    }

    @Override
    public Object postProcessAfterInitialization(Object o, String s) throws BeansException {
        if(o instanceof EntityManagerFactory) {
            System.out.println("After EntityManagerFactory Initialization");
            EntityManagerFactory emf = (EntityManagerFactory) o;
            SchemaExport schemaExport = new SchemaExport(new ConnectionHelper() {
                @Override
                public void prepare(boolean needsAutoCommit) throws SQLException {

                }

                @Override
                public Connection getConnection() throws SQLException {
                    Connection connection = DriverManager.getConnection(url, userName, password);
                    return connection;
                }

                @Override
                public void release() throws SQLException {

                }
            }, dropSql, createSql);
            schemaExport.drop(true, true);
            System.out.println("tables dropped");
            schemaExport.create(true,true);


        }
        return o;
    }
}
