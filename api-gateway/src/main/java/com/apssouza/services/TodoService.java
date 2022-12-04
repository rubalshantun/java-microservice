package com.apssouza.services;

import com.apssouza.pojos.Todo;

import java.util.List;

/**
 *
 * @author apssouza
 */
public interface TodoService {

    public List<Todo> getAll();

    public List<Todo> getTodoByUserEmaill(String email);

    Todo createTodo(Todo todo);
}
