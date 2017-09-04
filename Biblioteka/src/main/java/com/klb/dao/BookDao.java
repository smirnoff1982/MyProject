package com.klb.dao;

import com.klb.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Michał Makaruk on 08.07.2017.
 */
@Repository
public interface BookDao extends JpaRepository<Book, Long> {
}
