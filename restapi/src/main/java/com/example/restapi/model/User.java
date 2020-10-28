package com.example.restapi.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
public class User {
    @Id
    @GeneratedValue
    private int id;
    @NotNull
    @Size(min=2)
    @NotEmpty(message="a name canot be emptiy")
    private  String name;
    @OneToMany(mappedBy="user")
    private Set <Post> post;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Post> getPosts() {
        return post;
    }

    public void setPosts(Set<Post> posts) {
        this.post = posts;
    }
}
