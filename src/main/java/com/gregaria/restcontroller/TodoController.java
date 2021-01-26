package com.gregaria.restcontroller;

import java.util.Optional;

import com.gregaria.restcontroller.entities.Todo;
import com.gregaria.restcontroller.repositories.TodoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/todos")
public class TodoController {

    @Autowired
    private TodoRepository todoRepository;

    @GetMapping("")
    public @ResponseBody Iterable<Todo> getAllTodos() {
        return todoRepository.findAll();
    }

    @PostMapping("")
    public @ResponseBody Todo addNewTodo(@RequestParam String description, @RequestParam Boolean completed) {
        Todo t = new Todo(description, completed);
        todoRepository.save(t);
        return t;
    }

    @PostMapping("/toggle/{id}")
    public ResponseEntity<Todo> toggleCompleted(@PathVariable("id") Integer id) {
        Optional<Todo> optional = todoRepository.findById(id);
        if(optional.isEmpty()) {
            return new ResponseEntity<Todo>(HttpStatus.NOT_FOUND);
        }

        Todo t = optional.get();
        t.setCompleted(!t.getCompleted());
        todoRepository.save(t);
        return new ResponseEntity<Todo>(t, HttpStatus.OK);
    }

}
