package com.example.Trello.Group12.workspace;

import com.example.Trello.Group12.board.Board;
import com.example.Trello.Group12.board.BoardRepo;
import com.example.Trello.Group12.user.User;
import com.example.Trello.Group12.user.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class WorkspaceService {
    @Autowired WorkspaceRepo workspaceRepo;
    @Autowired UserRepo userRepo;
    @Autowired BoardRepo boardRepo;

    public int createWorkspace(String title, String description, String userID) {
        int id = Integer.parseInt(userID);
        Optional<User> user = userRepo.findById(id);
        if (user.isPresent()) {
            Workspace workspace = new Workspace(title, description, user.get());
            workspaceRepo.saveAndFlush(workspace);
            return workspace.getID();
        }
        return -1;
    }

    public Workspace updateWorkspace(String title, String description, int ID) {
        Workspace workspace = workspaceRepo.getReferenceById(ID);
        workspace.setDescription(description);
        workspace.setTitle(title);
        return workspaceRepo.save(workspace);
    }

    public Workspace addUserToWorkspace(int id, String email) {
        Workspace workspace = workspaceRepo.getReferenceById(id);
        workspace.addMember(userRepo.findByEmail(email).get(0));
        return workspaceRepo.save(workspace);
    }

    public Workspace addBoardToWorkspace(int id, String title) {
        Workspace workspace = workspaceRepo.getReferenceById(id);
        Board board = new Board(title);
        board = boardRepo.saveAndFlush(board);
        workspace.addBoard(board);
        return workspaceRepo.saveAndFlush(workspace);
    }

    public Workspace deleteBoardInWorkspace(int workspaceID, int boardID) {
        Workspace workspace = workspaceRepo.getReferenceById(workspaceID);
        List<Board> boards = workspace.getBoards();
        boards.remove(boardRepo.getReferenceById(boardID));
        workspace.setBoards(boards);
        return workspaceRepo.save(workspace);
    }

    public List<Board> getBoards(int id) {
        Optional<Workspace> workspace = workspaceRepo.findById(id);
        if (workspace.isPresent()) {
            return workspace.get().getBoards();
        } else {
            return null;
        }
    }

    public List<Workspace> getWorkspacesByUserId(int id) {
        List<Workspace> workspace = workspaceRepo.findByUserID(id);
        if (workspace.size() != 0) {
            return workspace;
        } else {
            return null;
        }
    }

    /*
    public int createTask(String title, int year, int month, int day, int userID, int workspaceID, int boardID){
        Optional<User> user = userRepo.findById(userID);
        Optional<Workspace> workspace = workspaceRepo.findById(workspaceID);
        Optional<Board> board = boardRepo.findById(boardID);
    }

     */
}
