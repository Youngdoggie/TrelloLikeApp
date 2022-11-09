package com.example.Trello.Group12.task;
import com.example.Trello.Group12.user.User;
import com.example.Trello.Group12.user.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class TaskService {
    @Autowired
    TaskRepo taskRepo;

    @Autowired
    UserRepo userRepo;

    public List<Task> getTasks(){
        return taskRepo.findAll();
    }
    public Task getTask(int id){
        if(taskRepo.findById(id).isPresent()){
            return taskRepo.findById(id).get();
        }
        return null;
    }

    public Task changeStatus(int id, int newStatus) {
        if(taskRepo.findById(id).isPresent()){
            Task task = taskRepo.findById(id).get();
            task.setStatus(newStatus);
            return taskRepo.save(task);
        }
        return null;
    }



    public List<Task> searchTasks(String name){
        List<Task> list = getTasks();
        return list.stream().filter(p -> p.getName().startsWith(name)).collect(Collectors.toList());
    }

    public boolean assignUserToTask(int taskID, String email){
        if(taskRepo.findById(taskID).isPresent() && userRepo.findByEmail(email).size() > 0) {
            Task task = taskRepo.findById(taskID).get();
            User user = userRepo.findByEmail(email).get(0);
            if(task.getUsers().contains(user)){
                return false;
            }
            task.addAssignee(user);
            taskRepo.save(task);
            return true;
        }
        return false;
    }
}
