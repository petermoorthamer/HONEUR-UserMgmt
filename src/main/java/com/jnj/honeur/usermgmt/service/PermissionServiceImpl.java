package com.jnj.honeur.usermgmt.service;

import com.jnj.honeur.usermgmt.model.Permission;
import com.jnj.honeur.usermgmt.repository.PermissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionServiceImpl implements PermissionService {

    private PermissionRepository permissionRepository;

    public PermissionServiceImpl(@Autowired PermissionRepository permissionRepository) {
        this.permissionRepository = permissionRepository;
    }

    @Override
    public List<Permission> findAll() {
        return permissionRepository.findAll();
    }

    @Override
    public Permission findById(Integer id) {
        return permissionRepository.findOne(id);
    }

    @Override
    public Permission save(Permission permission) {
        return permissionRepository.save(permission);
    }

    @Override
    public void delete(Integer permissionId) {
        permissionRepository.delete(permissionId);
    }
}