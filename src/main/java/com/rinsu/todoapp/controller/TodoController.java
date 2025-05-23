package com.rinsu.todoapp.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rinsu.todoapp.entity.Todo;
import com.rinsu.todoapp.dto.TodoDto;
import com.rinsu.todoapp.service.TodoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/todos")
public class TodoController {

    @Autowired
    private TodoService todoService;

    // Todo一覧を取得
    @GetMapping("/list")
    public List<Todo> getTodoList() {
        return todoService.getTodoList();
    }

    // Todoを追加
    @PostMapping("/add")
    public List<Todo> addTodo(@Valid @RequestBody TodoDto request) {
        return todoService.addTodo(request.getTitle(), request.getDeadline());
    }
    
    // Todoを削除
    @PostMapping("/delete/{id}")
    public void deleteTodo(@PathVariable int id) {
    	todoService.deleteTodo(id);
    }
}

