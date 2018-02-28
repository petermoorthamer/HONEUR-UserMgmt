package com.jnj.honeur.usermgmt.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * Links a {@link Permission} to a {@link Role}
 * @author Peter Moorthamer
 */
@Entity
@Table(name = "SEC_ROLE_PERMISSION")
public class RolePermission implements Serializable {


    @Id
    @Column(name = "ID")
    @SequenceGenerator(name = "SEC_ROLE_PERMISSION_SEQUENCE_GENERATOR", sequenceName = "SEC_ROLE_PERMISSION_SEQUENCE", allocationSize = 1, initialValue = 1000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEC_ROLE_PERMISSION_SEQUENCE_GENERATOR")
    private Integer id;
    @Column(name = "STATUS")
    private String status;
    @ManyToOne
    @JoinColumn(name = "ROLE_ID", nullable = false)
    private Role role;
    @ManyToOne
    @JoinColumn(name = "PERMISSION_ID", nullable = false)
    private Permission permission;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    public Role getRole() {
        return role;
    }
    public void setRole(Role role) {
        this.role = role;
    }

    public Permission getPermission() {
        return permission;
    }
    public void setPermission(Permission permission) {
        this.permission = permission;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RolePermission that = (RolePermission) o;
        if(that.id == null) {
            return false;
        }
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "RolePermission{" +
                "id=" + id +
                ", status='" + status + '\'' +
                ", role=" + role +
                ", permission=" + permission +
                '}';
    }
}
