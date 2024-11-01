package br.com.avasconcelos.desafio_todolist;

import br.com.avasconcelos.desafio_todolist.domain.entity.Todo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.context.SpringBootTest;

@ContextConfiguration(classes = DesafioTodolistApplication.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class DesafioTodolistApplicationTests {

	@Autowired
	private WebTestClient webTestClient;
	@Test
	void testCreateTodoSuccess() {

		var todo = new Todo("minha primeira tarefa", "descrição da minha primeira tarefa", false, 1);

		webTestClient
				.post()
				.uri("/todos")
				.bodyValue(todo)
				.exchange()
				.expectStatus().isEqualTo(201)
				.expectBody()
				.jsonPath("$").exists()
				.jsonPath("$.name").isEqualTo(todo.getName())
				.jsonPath("$.description").isEqualTo(todo.getDescription())
				.jsonPath("$.realized").isEqualTo(todo.getRealized())
				.jsonPath("$.priority").isEqualTo(todo.getPriority());

	}

}
