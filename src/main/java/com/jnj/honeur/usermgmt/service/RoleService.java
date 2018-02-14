package com.jnj.honeur.usermgmt.service;

import com.jnj.honeur.usermgmt.model.Role;

import java.util.List;

public interface RoleService {

    List<Role> findAll();

    Role findById(Integer id);

    Role save(Role user);

}
