package com.todo_app.todo_app.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/v1/tasks")
public class TaskController {
  @GetMapping("")
  public ResponseEntity<Map<String, Object>> getAllTasks(
      @RequestParam(defaultValue = "10") int limit,
      @RequestParam(defaultValue = "0") int offset) {
    List<Map<String, Object>> tasks = generateTasks(limit);
    Map<String, Object> response = new HashMap<>();
    response.put("tasks", tasks);
    response.put("limit", limit);
    response.put("offset", offset);
    return ResponseEntity.ok(response);
  }

  private List<Map<String, Object>> generateTasks(int count) {
    List<Map<String, Object>> tasks = new ArrayList<>();
    for(int i = 1; i <= count; i++) {
      tasks.add(createTask((long)i));
    }
    return tasks;
  }

  private Map<String, Object> createTask(Long id) {
    Map<String, Object> task = new HashMap<>();
    task.put("id", id);
    task.put("name", "Sample Task " + id);
    task.put("status", "pending");
    return task;
  }
}
