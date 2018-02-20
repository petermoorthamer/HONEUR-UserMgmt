package com.jnj.honeur.usermgmt.service;

import com.jnj.honeur.usermgmt.model.Permission;

import java.util.List;

public interface PermissionService {

    List<Permission> findAll();

    Permission findById(Integer id);

    Permission save(Permission user);

    void delete(Integer permissionId);

}
