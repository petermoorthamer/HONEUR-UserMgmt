package com.jnj.honeur.usermgmt.repository;

import com.jnj.honeur.usermgmt.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}
