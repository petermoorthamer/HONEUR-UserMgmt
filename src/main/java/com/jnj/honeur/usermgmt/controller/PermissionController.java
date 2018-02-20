package com.jnj.honeur.usermgmt.controller;

import com.jnj.honeur.usermgmt.exception.PermissionNotFoundException;
import com.jnj.honeur.usermgmt.model.Permission;
import com.jnj.honeur.usermgmt.service.PermissionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class PermissionController {

    private static final Logger LOG = LoggerFactory.getLogger(PermissionController.class);

    private PermissionService permissionService;

    public PermissionController(@Autowired PermissionService permissionService) {
        this.permissionService = permissionService;
    }

    @GetMapping("/permissions")
    @CrossOrigin(origins = "http://localhost:4200")
    public List<Permission> retrieveAllPermissions() {
        return permissionService.findAll();
    }

    @GetMapping("/permissions/{id}")
    public Permission retrievePermission(@PathVariable int id) {
        Permission permission = permissionService.findById(id);

        if (permission == null)
            throw new PermissionNotFoundException("id-" + id);

        return permission;
    }

    @PostMapping("/permissions")
    public ResponseEntity<Object> createPermission(@RequestBody Permission permission) {
        Permission savedPermission = permissionService.save(permission);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedPermission.getId()).toUri();

        return ResponseEntity.created(location).build();

    }

    @PatchMapping("/permissions/{id}")
    public ResponseEntity<Object> updatePermission(@RequestBody Permission permission, @PathVariable int id) {

        Permission permissionEntity = permissionService.findById(id);

        if (permissionEntity == null)
            return ResponseEntity.notFound().build();

        permission.setId(id);

        permissionService.save(permission);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/permissions/{id}")
    public ResponseEntity<Object> deletePermission(@PathVariable int id) {

        Permission permissionEntity = permissionService.findById(id);

        if (permissionEntity == null)
            return ResponseEntity.notFound().build();

        permissionService.delete(id);

        return ResponseEntity.noContent().build();
    }

}
