package br.com.avasconcelos.desafio_todolist.controller;

import br.com.avasconcelos.desafio_todolist.domain.entity.Todo;
import br.com.avasconcelos.desafio_todolist.service.ITodoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class TodoController {

    private final ITodoService service;

    public TodoController(ITodoService service) {
        this.service = service;
    }

    @PostMapping("/todo")
    public ResponseEntity<Todo> create(@RequestParam Todo todo){
        return ResponseEntity.status(201).build();
    }

    @PutMapping("/todo")
    public ResponseEntity<Todo> update(@RequestParam Todo todo){
        return ResponseEntity.ok().build();
    }

    @GetMapping("/todo")
    public ResponseEntity<Todo> listAll(){
        return ResponseEntity.ok().build();
    }

    @GetMapping("/todo/{name}")
    public ResponseEntity<Todo> listByName(@PathVariable String name){
        return ResponseEntity.ok().build();
    }

    @PostMapping("/todo/delete/{id}")
    public ResponseEntity<Todo> delete(@PathVariable Integer id){
        return ResponseEntity.ok().build();
    }
}
