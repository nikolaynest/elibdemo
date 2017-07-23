package com.elibrary.controllers;

import com.elibrary.dao.AuthorsRepository;
import com.elibrary.entities.Author;
import com.elibrary.entities.Sex;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;

/**
 * Created by nikolay on 23.07.17.
 */
@Controller
@RequestMapping("/author/info/short")
public class AuthorsController {

    private AuthorsRepository authorsRepository;

    @RequestMapping(value = "/{authorId}", method = RequestMethod.GET)
    public Author getAuthorInfo(@PathVariable("authorId") Long authorId, Model model) {
        Author author = authorsRepository.findById(authorId);
        return author;
    }

    @RequestMapping("/test")
    public Author getAuthor() {
        Author author = new Author();
        author.setId(123L);
        author.setBirthDate(new Date());
        author.setFirstName("Nik");
        author.setLastName("Nesterenko");
        author.setSex(Sex.MALE);
        return author;
    }
}
