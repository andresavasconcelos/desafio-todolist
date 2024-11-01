package br.com.avasconcelos.desafio_todolist.service;

import br.com.avasconcelos.desafio_todolist.domain.entity.Todo;

import java.util.List;

public interface ITodoService {

    Todo create(Todo todo);
    Todo update(Todo todo);
    List<Todo> listAll();
    Todo listByName(String name);
    void delete(Todo todo);
}
