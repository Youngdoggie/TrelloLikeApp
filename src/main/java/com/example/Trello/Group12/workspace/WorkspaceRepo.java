package com.example.Trello.Group12.workspace;

import com.example.Trello.Group12.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkspaceRepo extends JpaRepository<Workspace, Integer> {
    @Query(value = "SELECT * FROM csci3130_group12.workspace_users u" +
            " LEFT OUTER JOIN workspace" +
            " ON workspace.id = u.workspaces_id" +
            " WHERE users_id = ?1", nativeQuery = true)
    List<Workspace> findByUserID(int id);
}
