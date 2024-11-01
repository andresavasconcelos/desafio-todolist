package br.com.avasconcelos.desafio_todolist.service;

import br.com.avasconcelos.desafio_todolist.domain.entity.Todo;
import br.com.avasconcelos.desafio_todolist.repository.TodoRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoServiceImpl implements ITodoService{

    private final TodoRepository repository;

    public TodoServiceImpl(TodoRepository repository) {
        this.repository = repository;
    }

    @Override
    public Todo create(Todo todo) {
        return repository.save(todo);
    }

    @Override
    public Todo update(Todo todo) {
        return repository.save(todo);
    }

    @Override
    public List<Todo> listAll() {
        Sort sort = Sort.by("proprety").descending()
                .and(Sort.by("name").ascending());
        return repository.findAll(sort);
    }

    @Override
    public Todo findByName(String name) {
        return repository.findByName(name);
    }

    @Override
    public void delete(Todo todo) {
        repository.delete(todo);
    }
}
