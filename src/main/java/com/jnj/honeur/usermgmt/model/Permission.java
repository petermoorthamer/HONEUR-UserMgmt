package com.jnj.honeur.usermgmt.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * Represents a permission to access a resource or perform an action
 * @author Peter Moorthamer
 */
@Entity
@Table(name="SEC_PERMISSION")
public class Permission implements Serializable {

    @Id
    @Column(name = "ID")
    @SequenceGenerator(name = "SEC_PERMISSION_SEQUENCE_GENERATOR", sequenceName = "SEC_PERMISSION_SEQUENCE", allocationSize = 1, initialValue = 1000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEC_PERMISSION_SEQUENCE_GENERATOR")
    private Integer id;

    @Column(name="VALUE")
    private String value;

    @Column(name="DESCRIPTION")
    private String description;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }
    public void setValue(String value) {
        this.value = value;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Permission that = (Permission) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Permission{" +
                "id=" + id +
                ", value='" + value + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
