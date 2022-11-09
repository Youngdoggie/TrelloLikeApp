package com.example.Trello.Group12.board;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardRepo extends JpaRepository<Board, Integer>  {

}
