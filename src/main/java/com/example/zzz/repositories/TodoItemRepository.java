package com.example.zzz.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.zzz.entity.TodoItem;

public interface TodoItemRepository extends JpaRepository<TodoItem, Long> {

	public List<TodoItem> findByDoneOrderByTitleAsc(boolean done);

}
