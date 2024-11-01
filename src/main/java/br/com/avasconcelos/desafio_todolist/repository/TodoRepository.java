package br.com.avasconcelos.desafio_todolist.repository;

import br.com.avasconcelos.desafio_todolist.domain.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Integer> {

    public Todo findByName(String name);
}
