package com.digitalhouse.ApiFilmes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digitalhouse.ApiFilmes.model.Filme;
import com.digitalhouse.ApiFilmes.repository.FilmeRepository;

//3

@Service
public class FilmeService {
	
	/* Autowired inicializa o objeto sem necessitar de "= new FilmeRepository" */
	@Autowired
	private FilmeRepository repository;

	/* para chamar a lista inteira, precisamos pedir ao repository */
	public List<Filme> selectAll() {
		return repository.findAll();
	}

	/*
	 * .get() no final faz com que ele pegue só o objeto do id melhor findById ao
	 * invés do get, porq o Option será necessário para futuro tratamento Vai
	 * retornar um objeto, então public FILME
	 */
	public Filme select(Integer id) {
		return repository.findById(id).get();
	}

	/* Vai deletar um objeto, não retorna nada */
	public void delete(Integer id) {
		repository.deleteById(id);
	}

	/* Para criar, vamos precisar de todas as infos do objeto 
	 * Caso o ID seja igual à algum já existente no banco, o create substitui os valores do id
	 * Então, os valores do objeto do antigo ID vai sumir e os novos valores vão ficar no lugar
	 * */
	public Filme create(Filme filme) {
		return repository.save(filme);
	}
	
//	Só montamos o update para atualizar dados que não podem ser editáveis
	public Filme update(Filme filme) {
//		busco no DB
		Filme filmeUpdate = repository.findById(filme.getId()).get();
//		modificou descricao e url da img
		filmeUpdate.setDescricao(filme.getDescricao());
		filmeUpdate.setUrlImg(filme.getUrlImg());
		return repository.save(filmeUpdate);
	}
}
