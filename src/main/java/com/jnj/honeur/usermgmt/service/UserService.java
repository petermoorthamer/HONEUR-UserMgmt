package com.jnj.honeur.usermgmt.service;

import com.jnj.honeur.usermgmt.model.User;

import java.util.List;

public interface UserService {

    List<User> findAll();

    User findById(Integer id);

    User findByName(String name);

    User save(User user);

    void delete(Integer userId);

}
