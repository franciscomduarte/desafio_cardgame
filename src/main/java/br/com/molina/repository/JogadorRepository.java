package br.com.molina.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.molina.entity.Jogador;

@Repository
public interface JogadorRepository extends JpaRepository<Jogador, Long>{

}
