package com.digitalhouse.ApiFilmes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.digitalhouse.ApiFilmes.model.Filme;

/*2
Já extends, então não precisa, mas bota pra explicitar*/

@Repository
public interface FilmeRepository extends JpaRepository<Filme, Integer> {

}
