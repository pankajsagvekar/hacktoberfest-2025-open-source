package com.todo_app.todo_app.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/v1/todos")
public class TodoController {

  // Get All Todos
  @GetMapping()
  public ResponseEntity<Map<String, Object>> getAll()
  {
    List<Map<String, Object>> todos = generateTodos(20);
    Map<String, Object> response = new HashMap<>();
    response.put("todos", todos);
    return ResponseEntity.ok(response);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Map<String, Object>> getTodoById(@PathVariable Long id) {
    Map<String, Object> todo = createTodo(id);
    return ResponseEntity.ok(todo);
  }


  private List<Map<String, Object>> generateTodos(int count) {
    List<Map<String, Object>> todos = new ArrayList<>();
    for(int i = 1; i <= count; i++) {
      todos.add(createTodo((long)i));
    }
    return todos;
  }

  private Map<String, Object> createTodo(Long id) {
    Map<String, Object> todo = new HashMap<>();
    todo.put("id", id);
    todo.put("title", "Sample Todo " + id);
    todo.put("completed", false);
    return todo;
  }
}
