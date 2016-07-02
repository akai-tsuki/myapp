package com.example.zzz;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.zzz.entity.TodoItem;
import com.example.zzz.entity.TodoItemForm;
import com.example.zzz.repositories.TodoItemRepository;

@Controller
public class PostgreSQLAppController {
	@Autowired
	TodoItemRepository repository;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String index(@ModelAttribute TodoItemForm todoItemForm, @RequestParam("isDone") Optional<Boolean> isDone) {
		todoItemForm.setDone(isDone.isPresent() ? isDone.get() : false);
		todoItemForm.setTodoItems(this.repository.findByDoneOrderByTitleAsc(todoItemForm.isDone()));
		return "list";
	}

	@RequestMapping(value = "/done", method = RequestMethod.POST)
	public String done(@RequestParam("id") long id) {
		TodoItem item = this.repository.findOne(id);
		item.setDone(true);
		this.repository.save(item);
		return "redirect:/list?isDone=false";
	}

	@RequestMapping(value = "/restore", method = RequestMethod.POST)
	public String restore(@RequestParam("id") long id) {
		TodoItem item = this.repository.findOne(id);
		item.setDone(false);
		this.repository.save(item);
		return "redirect:/list?isDone=true";
	}

	@RequestMapping(value = "/new", method = RequestMethod.POST)
	public String newItem(TodoItem item) {
		item.setDone(false);
		this.repository.save(item);
		return "redirect:/list";
	}
}
