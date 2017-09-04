package com.klb.service;

import com.klb.entity.Book;
import com.klb.entity.Rent;
import com.klb.entity.User;

import java.util.List;

/**
 * Created by Michał Makaruk on 08.07.2017.
 */

public interface RentService {
    void createRent(User user, Book book);
    List<Rent> findAll();
    List<Rent> findByUserOrderByCreatedDateDesc(User user);
}
