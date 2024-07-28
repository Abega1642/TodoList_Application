package com.hei.hackathon.hackathon.controller;

import com.hei.hackathon.hackathon.dto.ToDoListDto;
import com.hei.hackathon.hackathon.entity.ToDoList;
import com.hei.hackathon.hackathon.services.TodoListServices;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/back/data/todoLists")
public class ToDoListController {
    TodoListServices todoListServices;

    @GetMapping
    public ResponseEntity<List<ToDoListDto>> getToDoLists() {
        List<ToDoListDto> todoLists = todoListServices.getAllTodoList();
        return ResponseEntity.ok(todoLists);
    }

    @GetMapping("{toDoListId}")
    public ResponseEntity<ToDoListDto> getToDoList(@PathVariable("toDoListId") String toDoListId) {
        ToDoListDto toDoList = todoListServices.getTodoListById(toDoListId);
        return ResponseEntity.ok(toDoList);
    }

    @PostMapping
    public ResponseEntity<ToDoListDto> addToDoList(@RequestBody ToDoListDto toDoListDto) {
        ToDoListDto addedToDoList = todoListServices.createTodoList(toDoListDto);
        return new ResponseEntity<>(addedToDoList, HttpStatus.CREATED);
    }
}
