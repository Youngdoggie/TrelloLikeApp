package com.example.Trello.Group12.board;

import com.example.Trello.Group12.task.Task;
import com.example.Trello.Group12.task.TaskRepo;
import com.example.Trello.Group12.user.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
@Transactional
public class BoardService {

    @Autowired
    BoardRepo boardRepo;
    @Autowired
    UserRepo userRepo;
    @Autowired
    TaskRepo taskRepo;


    public Board getBoard(int id) {
        if (boardRepo.findById(id).isPresent()) {
            return boardRepo.findById(id).get();
        }
        return null;
    }


    public Board addTask(int id, Date dueDate,  String title, String desc) {
        int  toDoState;
        Date today = new Date();
        SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMdd");

        if(fmt.format(dueDate).equals(fmt.format(today))){
            toDoState = 1;
        }else if(dueDate.compareTo(today) < 0){
            toDoState = 2;
        }else{
            toDoState = 0;
        }
        Optional<Board> boardOptional = boardRepo.findById(id);
        if (boardOptional.isPresent()) {
            Board board = boardOptional.get();
            Task task = new Task(title, dueDate, toDoState, desc);
            taskRepo.save(task);
            board.addTask(task);
            return boardRepo.save(board);
        } else {
            return null;
        }
    }

    public List<Task> getTasks(int id) {
        if (boardRepo.findById(id).isPresent()) {
            return boardRepo.findById(id).get().getTasks();
        }
        return null;
    }

    public List<Task> filterByDueToday(int id){
        List<Task> list = getTasks(id);
        List<Task> comparedList = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        for(Task task : list){
            Date today = new Date();
            Date compare = task.getDueDate();
            if(sdf.format(today).equals(sdf.format(compare))){
                comparedList.add(task);
            }
        }
        return comparedList;
    }

    public List<Task> filterByOverdue(int id){
        List<Task> list = getTasks(id);
        List<Task> comparedList = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        for(Task task : list){
            Date today = new Date();
            Date compare = task.getDueDate();
            if(sdf.format(today).compareTo(sdf.format(compare)) > 0){
                comparedList.add(task);
            }
        }
        return comparedList;
    }

    public List<Task> filterByInAWeek(int id){
        List<Task> list = getTasks(id);
        List<Task> comparedList = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        for(Task task : list){
            Date today = new Date();
            Calendar today2 = Calendar.getInstance();
            today2.add(Calendar.DAY_OF_MONTH, 7);
            Date compare = task.getDueDate();
            if(sdf.format(today).compareTo(sdf.format(compare)) < 0 && sdf.format(today2.getTime()).compareTo(sdf.format(compare)) > 0){
                comparedList.add(task);
            }
        }
        return comparedList;
    }
}
