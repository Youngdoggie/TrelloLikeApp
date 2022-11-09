package com.example.Trello.Group12.board;

import com.example.Trello.Group12.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.*;

@RestController
@Transactional
@CrossOrigin(origins = "*")
@RequestMapping("/board")
public class BoardController {
    @Autowired BoardService boardService;

    @GetMapping("/{ID}")
    public Board getBoard(@PathVariable int ID) {
        return boardService.getBoard(ID);
    }

    @GetMapping("/tasks/{ID}")
    public List<Task> getTasks(@PathVariable int ID) {
      return boardService.getTasks(ID);
   }

    @GetMapping("/tasks/0/{ID}")
    public List<Task> getDueInWeek(@PathVariable int ID) {
        return boardService.filterByInAWeek(ID);
    }

    @GetMapping("/tasks/1/{ID}")
    public List<Task> getDueToday(@PathVariable int ID) {
        return boardService.filterByDueToday(ID);
    }

    @GetMapping("/tasks/2/{ID}")
    public List<Task> getOverDue(@PathVariable int ID) {
        return boardService.filterByOverdue(ID);
    }

    @PostMapping("/{ID}")
    public Board addTaskToBoard(@PathVariable int ID, @RequestBody Map<String, String> body) {
        int day = Integer.parseInt(body.get("day"));
        int month = Integer.parseInt(body.get("month"));
        int year = Integer.parseInt(body.get("year"));
        Date date = new GregorianCalendar(year,month-1,day).getTime();
        String title = body.get("title");
        String desc = body.get("desc");
        return boardService.addTask(ID, date, title, desc);
    }
}
