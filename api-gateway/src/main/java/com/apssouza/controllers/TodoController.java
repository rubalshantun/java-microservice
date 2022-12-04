package com.apssouza.controllers;

import com.apssouza.clients.TodoClient;
import com.apssouza.pojos.Todo;
import com.apssouza.pojos.User;
import com.apssouza.services.TodoService;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * To Do entry point
 *
 * @author apssouza
 */
@RequestMapping("/todos")
@RestController
public class TodoController {

    @Autowired
    TodoService todoService;

    @GetMapping
    public List<Todo> all() {
        return this.todoService.getAll();
    }

    @GetMapping("search")
    public List<Todo> getByUserEmail(@RequestParam("email") String email) {
        return this.todoService.getTodoByUserEmaill(email);
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody @Valid Todo todo, BindingResult result) {
        todoService.createTodo(todo);
        if (result.hasErrors()) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.noContent().build();
    }

}
