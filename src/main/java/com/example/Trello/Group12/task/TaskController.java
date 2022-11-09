package com.example.Trello.Group12.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;

@RestController
@Transactional
@CrossOrigin(origins = "*")
@RequestMapping("/task")
public class TaskController {
    @Autowired TaskService taskService;

    @GetMapping("/{ID}")
    public Task getTask(@PathVariable int ID){
        return taskService.getTask(ID);
    }

    @PutMapping("/{ID}")
    public Task changeStatus(@PathVariable int ID, @RequestBody Map<String, String> body) {
        int newStatus = Integer.parseInt(body.get("status"));
        return taskService.changeStatus(ID, newStatus);
    }

    @PatchMapping("/{ID}")
    public void assignUserToTask(@PathVariable int ID, @RequestBody Map<String, String> body) {
        String email = body.get("email");
        taskService.assignUserToTask(ID, email);
    }
}
