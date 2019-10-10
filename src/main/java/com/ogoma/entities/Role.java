package com.ogoma.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public String name;
    public String description;
    //When mappedBy is not used, both enties will try to create a foreign key or joinTable
    //we tell this entity that User enity is going to create the foreign key using role field

    //Use
    @OneToMany(mappedBy = "role", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<User> userSet = new HashSet<>();

    public Long getId() {
        return id;
    }

    public Role setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Role setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Role setDescription(String description) {
        this.description = description;
        return this;
    }

    public Set<User> getUserSet() {
        return userSet;
    }

    public Role setUserSet(Set<User> userSet) {
        this.userSet = userSet;
        return this;
    }

    // added to save parent child data
    public void addUser(User user) {
        this.userSet.add(user);
        user.setRole(this);
    }
}
