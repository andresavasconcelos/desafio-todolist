package br.com.avasconcelos.desafio_todolist.controller;

import br.com.avasconcelos.desafio_todolist.domain.entity.Todo;
import br.com.avasconcelos.desafio_todolist.service.ITodoService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TodoController {

    private final ITodoService service;

    protected static final Logger log = LogManager.getLogger();

    public TodoController(ITodoService service) {
        this.service = service;
    }

    @PostMapping("/todos")
    public ResponseEntity<Todo> create(@RequestBody Todo todo){
        try{
            log.info("Starting method create");

            Todo resp = service.create(todo);
            if(resp != null){
                log.info("Finished method create success");
                return ResponseEntity.status(201).body(resp);
            }

        }catch (Exception e){
            log.info("LOG - Error to create" + e.getMessage());
        }

        return ResponseEntity.badRequest().build();
    }

    @PutMapping("/todos/{id}")
    public ResponseEntity<Todo> update(@RequestBody Todo todo, @PathVariable Integer id){
        try{
            log.info("Starting method create");
            todo.setId(id);

            Todo resp = service.update(todo);
            if(resp != null){
                log.info("Finished method update success");
                return ResponseEntity.ok().body(resp);
            }

        }catch (Exception e){
            log.info("LOG - Error to update " + e.getMessage());
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/todos")
    public ResponseEntity<List<Todo>> listAll(){
        try{
            log.info("Starting method listAll");

            List<Todo> resp = service.listAll();
            if(resp != null){
                log.info("Finished method listAll success");
                return ResponseEntity.ok().body(resp);
            }

        }catch (Exception e){
            log.info("LOG - Error to listAll " + e.getMessage());
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/todos/{name}")
    public ResponseEntity<Todo> findByName(@PathVariable String name){
        try{
            log.info("Starting method findByName");

            Todo resp = service.findByName(name);
            if(resp != null){
                log.info("Finished method findByName success");
                return ResponseEntity.ok().body(resp);
            }

        }catch (Exception e){
            log.info("LOG - Error to findByName " + e.getMessage());
        }
        return ResponseEntity.badRequest().build();
    }

    @PostMapping("/todos/delete/{id}")
    public ResponseEntity<Todo> delete(@PathVariable Integer id){
        try{
            log.info("Starting method delete");

            Todo todo = new Todo();
            todo.setId(id);

            service.delete(todo);

            log.info("Finished method delete success");
            return ResponseEntity.ok().build();

        }catch (Exception e){
            log.info("LOG - Error to delete" + e.getMessage());
        }
        return ResponseEntity.badRequest().build();
    }
}
