package com.library.model;
import jakarta.persistence.*;

@Entity @Table(name = "users")
public class User {
    private String username;
    private String password;
    private String role;

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    User(){}

    public User(String username, String password, String role){
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public String getUsername(){ return username; }
    public String getPassword(){ return password; }
    public String getRole() { return role; }
    public Long getId() { return id; }

}
