package com.jnj.honeur.usermgmt.service;

import com.jnj.honeur.usermgmt.model.User;
import com.jnj.honeur.usermgmt.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    public UserServiceImpl(@Autowired UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(Integer id) {
        return userRepository.findOne(id);
    }

    @Override
    public User findByName(String name) {
        User userProbe = new User();
        userProbe.setName(name);
        Example<User> userCriteria = Example.of(userProbe);
        return userRepository.findOne(userCriteria);
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

}
