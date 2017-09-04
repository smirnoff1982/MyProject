package com.klb.service;

import com.klb.entity.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

/**
 * Created by Michał Makaruk on 08.07.2017.
 */
public interface UserService extends UserDetailsService {
    void save(User user);
    User finByEmail(String email);
    List<User> findAll();
    void delete(Long id);
    User findOne(Long id);
}
