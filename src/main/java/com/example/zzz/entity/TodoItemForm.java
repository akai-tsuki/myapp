package com.example.zzz.entity;

import java.util.List;

public class TodoItemForm {
	private boolean isDone;

	private List<TodoItem> todoItems;

	public List<TodoItem> getTodoItems() {
		return todoItems;
	}

	public void setTodoItems(List<TodoItem> todoItems) {
		this.todoItems = todoItems;
	}

	public boolean isDone() {
		return isDone;
	}

	public void setDone(boolean isDone) {
		this.isDone = isDone;
	}
}
