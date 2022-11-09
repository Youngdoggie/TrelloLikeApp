package com.example.Trello.Group12;

import com.example.Trello.Group12.board.Board;
import com.example.Trello.Group12.board.BoardController;
import com.example.Trello.Group12.board.BoardRepo;
import com.example.Trello.Group12.board.BoardService;
import com.example.Trello.Group12.task.Task;
import com.example.Trello.Group12.task.TaskController;
import com.example.Trello.Group12.task.TaskRepo;
import com.example.Trello.Group12.task.TaskService;
import com.example.Trello.Group12.user.User;
import com.example.Trello.Group12.user.UserController;
import com.example.Trello.Group12.user.UserRepo;
import com.example.Trello.Group12.user.UserService;
import com.example.Trello.Group12.workspace.Workspace;
import com.example.Trello.Group12.workspace.WorkspaceController;
import com.example.Trello.Group12.workspace.WorkspaceRepo;
import com.example.Trello.Group12.workspace.WorkspaceService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;

import javax.transaction.Transactional;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringJUnitConfig
@SpringBootTest
@SpringJUnitWebConfig
class Group12Tests {
    @Autowired UserService userService;
    @Autowired UserRepo userRepo;
    @Autowired UserController userController;


    @Autowired WorkspaceController workspaceController;
    @Autowired WorkspaceRepo workspaceRepo;
    @Autowired WorkspaceService workspaceService;

    @Autowired
    BoardRepo boardRepo;
    @Autowired
    BoardService boardService;
    @Autowired
    BoardController boardController;


    @Autowired
    TaskService taskService;
    @Autowired
    TaskRepo taskRepo;
    @Autowired
    TaskController taskController;



    @Transactional
    @Test
    void contextLoads() {
        workspaceRepo.deleteAll();
        userRepo.deleteAll();
        boardRepo.deleteAll();
        taskRepo.deleteAll();
    }


    @Transactional
    @Test
    void testFindByEmail(){
        boardRepo.deleteAll();
        workspaceRepo.deleteAll();
        taskRepo.deleteAll();
        userRepo.deleteAll();
        User user = new User("Test@gmail.com", "Test", "Test");
        userService.registerUser(user);
        assertEquals(userRepo.findByEmail("Test@gmail.com").get(0).getEmail(), user.getEmail());
    }

    @Transactional
    @Test
    void testCreateUser() {
        boardRepo.deleteAll();
        workspaceRepo.deleteAll();
        taskRepo.deleteAll();
        userRepo.deleteAll();
        User user = new User("Test@gmail.com", "Test", "Test");
        assertTrue(userService.registerUser(user));
    }

    @Transactional
    @Test
    void testLogin(){
        boardRepo.deleteAll();
        workspaceRepo.deleteAll();
        taskRepo.deleteAll();
        userRepo.deleteAll();
        User user = new User("Test@gmail.com", "Test", "Test");
        userController.registerUser(user);
        assertEquals(userService.login("Test@gmail.com", "Test"), user.getID());
    }

    @Transactional
    @Test
    void testForgotPassword() {
        boardRepo.deleteAll();
        workspaceRepo.deleteAll();
        taskRepo.deleteAll();
        userRepo.deleteAll();
        User user = new User("Test@gmail.com", "Test", "Test");
        userController.registerUser(user);
        userService.forgotPassword("Test@gmail.com", "Test", "New Test");
        assertEquals(userRepo.findByEmail("Test@gmail.com").get(0).getPassword(), "New Test");

    }

    @Transactional
    @Test
    void testGetWorkspaces(){
        boardRepo.deleteAll();
        workspaceRepo.deleteAll();
        taskRepo.deleteAll();
        userRepo.deleteAll();
        User user = new User("Test@gmail.com", "Test", "Test");
        userService.registerUser(user);
        userService.login("Test@gmail.com", "Test");
        workspaceService.createWorkspace("Test Workspace", "Test Description", String.valueOf(user.getID()));
        assertEquals("Test Workspace", workspaceService.getWorkspacesByUserId(user.getID()).get(0).getTitle());
    }

    @Transactional
    @Test
    void testgetWorkspaces(){
        boardRepo.deleteAll();
        workspaceRepo.deleteAll();
        taskRepo.deleteAll();
        userRepo.deleteAll();
        User user = new User("Test@gmail.com", "Test", "Test");
        userService.registerUser(user);
        userService.login("Test@gmail.com", "Test");
        workspaceService.createWorkspace("Test Workspace", "Test Description", String.valueOf(user.getID()));
        assertNotNull(userService.getWorkspaces(user.getID()));
    }

    @Transactional
    @Test
    void testCreateWorkspace(){
        boardRepo.deleteAll();
        workspaceRepo.deleteAll();
        taskRepo.deleteAll();
        userRepo.deleteAll();
        User user = new User("Test@gmail.com", "Test", "Test");
        userService.registerUser(user);
        userService.login("Test@gmail.com", "Test");
        workspaceService.createWorkspace("Test Workspace", "Test Description", String.valueOf(user.getID()));
        assertEquals(workspaceRepo.findByUserID(user.getID()).get(0).getTitle(), "Test Workspace");
    }

    @Transactional
    @Test
    void testGetWorkspaceByID(){
        boardRepo.deleteAll();
        workspaceRepo.deleteAll();
        taskRepo.deleteAll();
        userRepo.deleteAll();
        User user = new User("Test@gmail.com", "Test", "Test");
        userService.registerUser(user);
        userService.login("Test@gmail.com", "Test");
        workspaceService.createWorkspace("Test Workspace", "Test Description", String.valueOf(user.getID()));
        assertEquals(workspaceService.getWorkspacesByUserId(user.getID()).get(0).getTitle(), "Test Workspace");
    }
    @Transactional
    @Test
    void testAddMemberToWorkspace(){
        boardRepo.deleteAll();
        workspaceRepo.deleteAll();
        taskRepo.deleteAll();
        userRepo.deleteAll();
        User user = new User("Test@gmail.com", "Test", "Test");
        User user2 = new User("Test2@gmail.com", "Test", "Test");
        userService.registerUser(user);
        userService.registerUser(user2);
        userService.login("Test@gmail.com", "Test");
        workspaceService.createWorkspace("Test Workspace", "Test Description", String.valueOf(user.getID()));
        workspaceService.addUserToWorkspace(workspaceRepo.findByUserID(user.getID()).get(0).getID(), "Test2@gmail.com");
        assertEquals(workspaceRepo.findByUserID(user.getID()).get(0).getMembers().get(1).getEmail(), "Test2@gmail.com");
    }

    @Transactional
    @Test
    void testUpdateWorkspaceDetails(){
        boardRepo.deleteAll();
        workspaceRepo.deleteAll();
        taskRepo.deleteAll();
        userRepo.deleteAll();
        User user = new User("Test@gmail.com", "Test", "Test");
        userService.registerUser(user);
        userService.login("Test@gmail.com", "Test");
        workspaceService.createWorkspace("Test Workspace", "Test Description", String.valueOf(user.getID()));
        assertEquals(workspaceService.updateWorkspace("Test Workspace Update", "Test Description Update", workspaceRepo.findByUserID(user.getID()).get(0).getID()).getTitle(), "Test Workspace Update");
        assertEquals(workspaceRepo.findByUserID(user.getID()).get(0).getTitle(), "Test Workspace Update");
        assertEquals(workspaceRepo.findByUserID(user.getID()).get(0).getDescription(), "Test Description Update");
    }

    @Transactional
    @Test
    void testCreateBoard(){
        boardRepo.deleteAll();
        workspaceRepo.deleteAll();
        taskRepo.deleteAll();
        userRepo.deleteAll();
        User user = new User("Test@gmail.com", "Test", "Test");
        userService.registerUser(user);
        userService.login("Test@gmail.com", "Test");
        workspaceService.createWorkspace("Test Workspace", "Test Description", String.valueOf(user.getID()));
        workspaceService.addBoardToWorkspace(workspaceRepo.findByUserID(user.getID()).get(0).getID(), "Test Board");
        assertEquals("Test Board", workspaceRepo.findByUserID(user.getID()).get(0).getBoards().get(0).getTitle());
        assertNotNull(boardService.getBoard(workspaceRepo.findByUserID(user.getID()).get(0).getBoards().get(0).getID()));
    }

    @Transactional
    @Test
    void testGetBoards(){
        boardRepo.deleteAll();
        workspaceRepo.deleteAll();
        taskRepo.deleteAll();
        userRepo.deleteAll();
        User user = new User("Test@gmail.com", "Test", "Test");
        userService.registerUser(user);
        userService.login("Test@gmail.com", "Test");
        int workspace = workspaceService.createWorkspace("Test Workspace", "Test Description", String.valueOf(user.getID()));
        workspaceService.addBoardToWorkspace(workspaceRepo.findByUserID(user.getID()).get(0).getID(), "Test Board");
        Board board = workspaceService.getBoards(workspace).get(0);
        assertEquals(board.getTitle(), "Test Board");
    }

    @Transactional
    @Test
    void testGetBoardByID(){
        boardRepo.deleteAll();
        workspaceRepo.deleteAll();
        taskRepo.deleteAll();
        userRepo.deleteAll();
        User user = new User("Test@gmail.com", "Test", "Test");
        userService.registerUser(user);
        userService.login("Test@gmail.com", "Test");
        workspaceService.createWorkspace("Test Workspace", "Test Description", String.valueOf(user.getID()));
        Workspace workspace = workspaceService.addBoardToWorkspace(workspaceRepo.findByUserID(user.getID()).get(0).getID(), "Test Board");
        assertEquals("Test Board", boardService.getBoard(workspace.getBoards().get(0).getID()).getTitle());
    }

    @Transactional
    @Test
    void testDeleteBoard(){
        boardRepo.deleteAll();
        workspaceRepo.deleteAll();
        taskRepo.deleteAll();
        userRepo.deleteAll();
        User user = new User("Test@gmail.com", "Test", "Test");
        userService.registerUser(user);
        userService.login("Test@gmail.com", "Test");
        workspaceService.createWorkspace("Test Workspace", "Test Description", String.valueOf(user.getID()));
        workspaceService.addBoardToWorkspace(workspaceRepo.findByUserID(user.getID()).get(0).getID(), "Test Board");
        workspaceService.deleteBoardInWorkspace(workspaceRepo.findByUserID(user.getID()).get(0).getID(), workspaceRepo.findByUserID(user.getID()).get(0).getBoards().get(0).getID());
        assertTrue(workspaceRepo.findByUserID(user.getID()).get(0).getBoards().isEmpty());
    }


    @Transactional
    @Test
    void testCreateTask(){
        boardRepo.deleteAll();
        workspaceRepo.deleteAll();
        taskRepo.deleteAll();
        userRepo.deleteAll();
        User user = new User("Test@gmail.com", "Test", "Test");
        userService.registerUser(user);
        userService.login("Test@gmail.com", "Test");
        workspaceService.createWorkspace("Test Workspace", "Test Description", String.valueOf(user.getID()));
        Workspace workspace = workspaceService.addBoardToWorkspace(workspaceRepo.findByUserID(user.getID()).get(0).getID(), "Test Board");
        Date date = new Date();
        boardService.addTask(boardService.getBoard(workspace.getBoards().get(0).getID()).getID(), date,   "Test Task", "Test Task Description");
        assertEquals(taskService.getTasks().get(0).getName(), "Test Task");
        assertNotNull(taskService.getTasks().get(0).getID());

    }

    @Transactional
    @Test
    void testAssignMembersToTask(){
        userRepo.deleteAll();
        workspaceRepo.deleteAll();
        boardRepo.deleteAll();
        taskRepo.deleteAll();
        User user = new User("Test@gmail.com", "Test", "Test");
        userService.registerUser(user);
        userService.login("Test@gmail.com", "Test");
        workspaceService.createWorkspace("Test Workspace", "Test Description", String.valueOf(user.getID()));
        Workspace workspace = workspaceService.addBoardToWorkspace(workspaceRepo.findByUserID(user.getID()).get(0).getID(), "Test Board");
        Date date = new Date();
        boardService.addTask(boardService.getBoard(workspace.getBoards().get(0).getID()).getID(), date,   "Test Task", "Test Task Description");
        User user2 = new User("Test2@gmail.com", "Test", "Test");
        userService.registerUser(user2);
        assertTrue(taskService.assignUserToTask(taskService.getTasks().get(0).getID(), user2.getEmail()));
        assert(taskService.getTasks().get(0).getUsers().contains(user2));
    }

    @Transactional
    @Test
    void testChangeTaskStatus(){
        boardRepo.deleteAll();
        workspaceRepo.deleteAll();
        taskRepo.deleteAll();
        userRepo.deleteAll();
        User user = new User("Test@gmail.com", "Test", "Test");
        userService.registerUser(user);
        userService.login("Test@gmail.com", "Test");
        workspaceService.createWorkspace("Test Workspace", "Test Description", String.valueOf(user.getID()));
        Workspace workspace = workspaceService.addBoardToWorkspace(workspaceRepo.findByUserID(user.getID()).get(0).getID(), "Test Board");
        Date date = new Date();
        boardService.addTask(boardService.getBoard(workspace.getBoards().get(0).getID()).getID(), date,   "Test Task", "Test Task Description");
        taskService.changeStatus(taskService.getTasks().get(0).getID(), 1);
        assertEquals(taskService.getTasks().get(0).getStatus(), 1);
    }

    @Transactional
    @Test
    void testGetTask(){
        boardRepo.deleteAll();
        workspaceRepo.deleteAll();
        taskRepo.deleteAll();
        userRepo.deleteAll();
        User user = new User("Test@gmail.com", "Test", "Test");
        userService.registerUser(user);
        userService.login("Test@gmail.com", "Test");
        workspaceService.createWorkspace("Test Workspace", "Test Description", String.valueOf(user.getID()));
        Workspace workspace = workspaceService.addBoardToWorkspace(workspaceRepo.findByUserID(user.getID()).get(0).getID(), "Test Board");
        Date date = new Date();
        boardService.addTask(boardService.getBoard(workspace.getBoards().get(0).getID()).getID(), date,   "Test Task", "Test Task Description");
        assertEquals(taskService.getTask(taskService.getTasks().get(0).getID()).getName(), "Test Task");
    }

    @Transactional
    @Test
    void testGetTasks(){
        boardRepo.deleteAll();
        workspaceRepo.deleteAll();
        taskRepo.deleteAll();
        userRepo.deleteAll();
        User user = new User("Test@gmail.com", "Test", "Test");
        userService.registerUser(user);
        userService.login("Test@gmail.com", "Test");
        workspaceService.createWorkspace("Test Workspace", "Test Description", String.valueOf(user.getID()));
        Workspace workspace = workspaceService.addBoardToWorkspace(workspaceRepo.findByUserID(user.getID()).get(0).getID(), "Test Board");
        Date date = new Date();
        Board board = boardService.addTask(boardService.getBoard(workspace.getBoards().get(0).getID()).getID(), date,   "Test Task", "Test Task Description");
        assertEquals(boardService.getTasks(board.getID()).get(0).getName(), "Test Task");
    }


    @Transactional
    @Test
    void testSearchTasks(){
        boardRepo.deleteAll();
        workspaceRepo.deleteAll();
        taskRepo.deleteAll();
        userRepo.deleteAll();
        User user = new User("Test@gmail.com", "Test", "Test");
        userService.registerUser(user);
        userService.login("Test@gmail.com", "Test");
        workspaceService.createWorkspace("Test Workspace", "Test Description", String.valueOf(user.getID()));
        Workspace workspace = workspaceService.addBoardToWorkspace(workspaceRepo.findByUserID(user.getID()).get(0).getID(), "Test Board");
        Date date = new Date();
        boardService.addTask(boardService.getBoard(workspace.getBoards().get(0).getID()).getID(), date,   "Test Task", "Test Task Description");
        boardService.addTask(boardService.getBoard(workspace.getBoards().get(0).getID()).getID(), date,  "Test Task 2", "Test Task Description");
        boardService.addTask(boardService.getBoard(workspace.getBoards().get(0).getID()).getID(), date,   "Test Task 3", "Test Task Description");
        List<Task> list = taskService.searchTasks("Test Task 2");
        assertEquals(list.size(), 1);
        assertEquals(list.get(0).getName(), "Test Task 2");
    }

    @Transactional
    @Test
    void testFilterByDueToday(){
        boardRepo.deleteAll();
        workspaceRepo.deleteAll();
        taskRepo.deleteAll();
        userRepo.deleteAll();
        User user = new User("Test@gmail.com", "Test", "Test");
        userService.registerUser(user);
        userService.login("Test@gmail.com", "Test");
        workspaceService.createWorkspace("Test Workspace", "Test Description", String.valueOf(user.getID()));
        Workspace workspace = workspaceService.addBoardToWorkspace(workspaceRepo.findByUserID(user.getID()).get(0).getID(), "Test Board");
        Date date = new Date();
        Calendar date2 = Calendar.getInstance();
        date2.add(Calendar.DATE, -3);
        Date date2R = date2.getTime();
        Calendar date3 = Calendar.getInstance();
        date3.add(Calendar.DATE, 3);
        Date date3R = date3.getTime();

        boardService.addTask(boardService.getBoard(workspace.getBoards().get(0).getID()).getID(), date,   "Test Task", "Test Task Description");
        boardService.addTask(boardService.getBoard(workspace.getBoards().get(0).getID()).getID(), date2R,  "Test Task 2", "Test Task Description");
        boardService.addTask(boardService.getBoard(workspace.getBoards().get(0).getID()).getID(), date3R,   "Test Task 3", "Test Task Description");

        assertEquals(boardService.filterByDueToday(workspace.getBoards().get(0).getID()).get(0).getName(), "Test Task");
    }

    @Transactional
    @Test
    void testFilterByOverdue(){
        boardRepo.deleteAll();
        workspaceRepo.deleteAll();
        taskRepo.deleteAll();
        userRepo.deleteAll();
        User user = new User("Test@gmail.com", "Test", "Test");
        userService.registerUser(user);
        userService.login("Test@gmail.com", "Test");
        workspaceService.createWorkspace("Test Workspace", "Test Description", String.valueOf(user.getID()));
        Workspace workspace = workspaceService.addBoardToWorkspace(workspaceRepo.findByUserID(user.getID()).get(0).getID(), "Test Board");
        Date date = new Date();
        Calendar date2 = Calendar.getInstance();
        date2.add(Calendar.DATE, -3);
        Date date2R = date2.getTime();
        Calendar date3 = Calendar.getInstance();
        date3.add(Calendar.DATE, 3);
        Date date3R = date3.getTime();

        boardService.addTask(boardService.getBoard(workspace.getBoards().get(0).getID()).getID(), date,   "Test Task", "Test Task Description");
        boardService.addTask(boardService.getBoard(workspace.getBoards().get(0).getID()).getID(), date2R,  "Test Task 2", "Test Task Description");
        boardService.addTask(boardService.getBoard(workspace.getBoards().get(0).getID()).getID(), date3R,   "Test Task 3", "Test Task Description");

        assertEquals(boardService.filterByOverdue(workspace.getBoards().get(0).getID()).get(0).getName(), "Test Task 2");
    }

    @Transactional
    @Test
    void testFilterByDueInAWeek(){
        boardRepo.deleteAll();
        workspaceRepo.deleteAll();
        taskRepo.deleteAll();
        userRepo.deleteAll();
        User user = new User("Test@gmail.com", "Test", "Test");
        userService.registerUser(user);
        userService.login("Test@gmail.com", "Test");
        workspaceService.createWorkspace("Test Workspace", "Test Description", String.valueOf(user.getID()));
        Workspace workspace = workspaceService.addBoardToWorkspace(workspaceRepo.findByUserID(user.getID()).get(0).getID(), "Test Board");
        Date date = new Date();
        Calendar date2 = Calendar.getInstance();
        date2.add(Calendar.DATE, -3);
        Date date2R = date2.getTime();
        Calendar date3 = Calendar.getInstance();
        date3.add(Calendar.DATE, 3);
        Date date3R = date3.getTime();

        boardService.addTask(boardService.getBoard(workspace.getBoards().get(0).getID()).getID(), date,   "Test Task", "Test Task Description");
        boardService.addTask(boardService.getBoard(workspace.getBoards().get(0).getID()).getID(), date2R,  "Test Task 2", "Test Task Description");
        boardService.addTask(boardService.getBoard(workspace.getBoards().get(0).getID()).getID(), date3R,   "Test Task 3", "Test Task Description");

        assertEquals(boardService.filterByInAWeek(workspace.getBoards().get(0).getID()).get(0).getName(), "Test Task 3");
    }










}