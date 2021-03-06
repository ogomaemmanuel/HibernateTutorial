package org.ogoma.entities;

import javax.persistence.*;
import java.util.Set;
import java.util.logging.Logger;

@Entity
@Table(name = "permissions")
@NamedQuery(name =Permission.FIND_BY_NAME,query = "select p from Permission p where name=:name")
public class Permission {
    public static final String FIND_BY_NAME="Permission.findByName";
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    @ManyToMany(mappedBy = "permissions")
    private Set<Role> roles;

    public Long getId() {
        return id;
    }

    public Permission setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Permission setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Permission setDescription(String description) {
        this.description = description;
        return this;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public Permission setRoles(Set<Role> roles) {
        this.roles = roles;
        return this;
    }
}
