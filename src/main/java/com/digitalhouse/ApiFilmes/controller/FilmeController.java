package com.digitalhouse.ApiFilmes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.digitalhouse.ApiFilmes.model.Filme;
import com.digitalhouse.ApiFilmes.service.FilmeService;

// Quando tentar falar com um frontend, se não configurar, a aplicação não deixa conectar, o @CrossOrigin habilita isso

@RestController
@RequestMapping("/filme")
@CrossOrigin(origins = "*", allowedHeaders = "")
public class FilmeController {

	@Autowired
	private FilmeService service;

	/*
	 * Quem acessar esse método irá acessar todos os filmes. Com GetMapping, dizemos
	 * q o método é um get do http.
	 */
	@GetMapping
	public List<Filme> getAll() {
		return service.selectAll();
	}

	/*
	 * Quando acessar o localhost:8080/filme/5, esse /5 é o GetMapping("/{id}"), o
	 * PathVariable diz que é para pegar da anotação, ou seja, da URL
	 */
	@GetMapping("/{id}")
	public Filme getById(@PathVariable Integer id) {
		return service.select(id);
	}

	/* .delete é void, então não podemos retornar ele */
	@DeleteMapping("/{id}")
	public String delete(@PathVariable Integer id) {
		service.delete(id);
		return "Filme deletado com sucesso!";
	}

	/* A annotation de @RequestBody automatiza o json em objeto e só aceita objetos do tipo Filme */
	@PostMapping
	public Filme post(@RequestBody Filme filme) {
		return service.create(filme);
	}
	
	/*A anotação faz update da informação*/
	@PutMapping
	public Filme put(@RequestBody Filme filme) {
		return service.update(filme);
	}

}
