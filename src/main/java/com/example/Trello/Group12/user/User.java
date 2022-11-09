package com.example.Trello.Group12.user;


import com.example.Trello.Group12.task.Task;
import com.example.Trello.Group12.workspace.Workspace;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int ID;
    private String email;
    private String password;
    private String answer;

    @ManyToMany(mappedBy = "users", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnore
    List<Workspace> workspaces = new ArrayList<>();

    @ManyToMany(mappedBy = "users", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    List<Task> tasks = new ArrayList<>();

    public User() { }

    public List<Workspace> getWorkspaces() {
        return workspaces;
    }

    public void setWorkspaces(List<Workspace> workspaces) {
        this.workspaces = workspaces;
    }

    public User(String email, String password, String answer){
        this.email = email;
        this.password = password;
        this.answer = answer;
    }

    /*
    Removed for long Parameter List Not used in current code anyways
    public User(int ID, String email, String password, String question, String answer){
        this.ID = ID;
        this.email = email;
        this.password = password;
        this.answer = answer;
    }
    */


    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    @Override
    public String toString() {
        return "User{" +
                "id:" + ID +
                ", email:'" + email +
                "', password:'" + password +
                "', answer:'" + answer +
                "'}";
    }
}
