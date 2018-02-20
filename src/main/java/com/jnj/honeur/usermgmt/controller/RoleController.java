package com.jnj.honeur.usermgmt.controller;

import com.jnj.honeur.usermgmt.exception.RoleNotFoundException;
import com.jnj.honeur.usermgmt.model.Role;
import com.jnj.honeur.usermgmt.model.RolePermission;
import com.jnj.honeur.usermgmt.service.RoleService;
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
@CrossOrigin()
public class RoleController {

    private static final Logger LOG = LoggerFactory.getLogger(RoleController.class);

    private RoleService roleService;

    public RoleController(@Autowired RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping("/roles")
    @CrossOrigin(origins = "http://localhost:4200")
    public List<Role> retrieveAllRoles() {
        return roleService.findAll();
    }

    @GetMapping("/roles/{id}")
    public Role retrieveRole(@PathVariable int id) {
        Role role = roleService.findById(id);

        if (role == null)
            throw new RoleNotFoundException("id-" + id);

        return role;
    }

    @PostMapping("/roles")
    public ResponseEntity<Object> createRole(@RequestBody Role role) {
        initRolePermissions(role);

        Role savedRole = roleService.save(role);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedRole.getId()).toUri();

        return ResponseEntity.created(location).build();

    }

    private void initRolePermissions(final Role role) {
        for(RolePermission rolePermission:role.getRolePermissions()) {
            rolePermission.setRole(role);
        }
    }

    @PatchMapping("/roles/{id}")
    public ResponseEntity<Object> updateRole(@RequestBody Role role, @PathVariable int id) {

        Role roleEntity = roleService.findById(id);

        if (roleEntity == null)
            return ResponseEntity.notFound().build();

        role.setId(id);

        roleService.save(role);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/roles/{id}")
    public ResponseEntity<Object> deleteRole(@PathVariable int id) {

        Role roleEntity = roleService.findById(id);

        if (roleEntity == null)
            return ResponseEntity.notFound().build();


        roleService.delete(id);

        return ResponseEntity.noContent().build();
    }

}
