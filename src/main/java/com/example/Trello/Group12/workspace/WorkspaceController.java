package com.example.Trello.Group12.workspace;

import com.example.Trello.Group12.board.Board;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;

@RestController
@Transactional
@CrossOrigin(origins = "*")
@RequestMapping("/workspace")
public class WorkspaceController {
    @Autowired WorkspaceService workspaceService;

    @GetMapping("/{ID}")
    public List<Board> getWorkspace(@PathVariable int ID) {
        return workspaceService.getBoards(ID);
    }

    @GetMapping("/user/{userID}")
    public List<Workspace> getWorkspacesByUserID(@PathVariable int userID) {
        return workspaceService.getWorkspacesByUserId(userID);
    }

    @PostMapping("/create")
    public int createWorkspace(@RequestBody Map<String, String> body) {
        String title = body.get("title");
        String description = body.get("description");
        String userId = body.get("userIdVal");
        return workspaceService.createWorkspace(title, description, userId);
    }

    @PutMapping("/{ID}")
    public Workspace updateWorkspace(@PathVariable int ID, @RequestBody Map<String, String> body) {
        String title = body.get("title");
        String description = body.get("description");
        return workspaceService.updateWorkspace(title, description, ID);
    }

    @PatchMapping("/{ID}")
    public Workspace addUserToWorkspace(@PathVariable int ID, @RequestBody Map<String, String> body) {
        String email = body.get("email");
        return workspaceService.addUserToWorkspace(ID, email);
    }

    @PostMapping("addBoard/{ID}")
    public List<Board> addBoardToWorkspace(@PathVariable int ID, @RequestBody Map<String, String> body) {
        String title = body.get("title");
        return workspaceService.addBoardToWorkspace(ID, title).getBoards();
    }

    @DeleteMapping("/{workspaceID}/{boardID}")
    public Workspace deleteBoardInWorkspace(@PathVariable int workspaceID, @PathVariable int boardID) {
        return workspaceService.deleteBoardInWorkspace(workspaceID, boardID);
    }
}
