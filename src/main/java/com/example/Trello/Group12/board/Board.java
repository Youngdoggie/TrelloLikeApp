package com.example.Trello.Group12.board;

import com.example.Trello.Group12.task.Task;
import com.example.Trello.Group12.workspace.Workspace;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int ID;
    String title;


    @ManyToOne
    @JoinColumn
    Workspace workspace;

    @OneToMany
    List<Task> tasks = new ArrayList<>();



    public Board() { }

    public Board(String title){
        this.title = title;
    }

    public Board(String title, int ID){

        this.title = title;
        this.ID = ID;
    }

    public void addTask(Task task) {
        tasks.add(task);
    }
    public List<Task> getTasks() {
        return tasks;
    }
    public int getID() {
        return ID;
    }

    public String getTitle() {
        return title;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}

