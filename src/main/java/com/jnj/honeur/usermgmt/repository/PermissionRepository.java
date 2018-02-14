package com.jnj.honeur.usermgmt.repository;

import com.jnj.honeur.usermgmt.model.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

@Repository
@CrossOrigin(origins = "http://localhost:4200")
public interface PermissionRepository extends JpaRepository<Permission, Integer> {
}
