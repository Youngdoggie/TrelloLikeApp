package com.example.Trello.Group12.workspace;

import com.example.Trello.Group12.board.Board;
import com.example.Trello.Group12.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table
public class Workspace{
    String title;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int ID;
    String description;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn
    @JsonIgnore
    List<User> users = new ArrayList<>();

    @OneToMany
    List<Board> boards = new ArrayList<>();




    public Workspace() {
    }


    public void setBoards(List<Board> boards) {
        this.boards = boards;
    }

    public List<Board> getBoards() {
        return boards;
    }

    public void addBoard(Board board) {
        boards.add(board);
    }



    public Workspace(String title, String description, User user){
        this.title = title;
        this.description = description;
        users.add(user);
    }

    public Workspace(String title, int ID, String description, User user){
        this.title = title;
        this.ID = ID;
        this.description = description;
        users.add(user);
    }

    public List<User> getMembers() {
        return users;
    }

    public void addMember(User user){
        users.add(user);
    }

    public String getTitle() {
        return title;
    }

    public int getID() {
        return ID;
    }

    public String getDescription() {
        return description;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Workspace{" +
                "id:" + ID +
                ", title:'" + title +
                "', description:'" + description +
                "'}";
    }
}
