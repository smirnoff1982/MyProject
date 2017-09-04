package com.klb.service;

import com.klb.entity.Book;
import com.klb.entity.User;

import java.util.List;

/**
 * Created by Michał Makaruk on 08.07.2017.
 */
public interface BookService {
    void save(Book book);
    List<Book> findAll();
    void delete(Long id);
    Book findOne(Long id);
}
