package com.elibrary.dao;

import com.elibrary.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by nikolay on 23.07.17.
 */
public interface AuthorsRepository extends JpaRepository<Author, Long> {

    Author findById(Long authorId);
}
