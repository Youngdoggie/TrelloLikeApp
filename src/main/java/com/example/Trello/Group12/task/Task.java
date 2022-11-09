package com.example.Trello.Group12.task;

import com.example.Trello.Group12.board.Board;
import com.example.Trello.Group12.user.User;
import com.example.Trello.Group12.user.UserRepo;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Entity
@Table
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int ID;

    String name;
    Date dueDate;


    // 0 - Due in this week
    // 1 - Due today
    // 2 - Overdue
    int status;


    String taskDesc;


    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn
    @JsonIgnore
    List<User> users = new ArrayList<>();

    @ManyToOne
    @JoinColumn
    Board board;

    public Task() { }

    public Task(String name, Date dueDate, int status, String desc) {
        this.name = name;
        this.dueDate = dueDate;
        this.status = status;
        this.taskDesc = desc;
    }
    /*
    Removed for long Parameter List Not used in current code anyways
    public Task(String name, Date dueDate, int status, String desc, int ID) {
        this.name = name;
        this.dueDate = dueDate;
        this.status = status;
        this.taskDesc = desc;
        this.ID = ID;
    }

     */

    public void addAssignee(User user) {
        users.add(user);
    }

    public List<User> getUsers() {
        return users;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setStatus(int newStatus) {
        this.status = newStatus;
    }

    public int getStatus() {
        return status;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setTaskDesc(String Desc){
        this.taskDesc = Desc;
    }
    public String getTaskDesc() {
        return taskDesc;
    }
}
