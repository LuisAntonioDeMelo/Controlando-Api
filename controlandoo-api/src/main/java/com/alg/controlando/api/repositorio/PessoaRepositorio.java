package com.alg.controlando.api.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alg.controlando.api.models.Pessoa;

public interface PessoaRepositorio extends JpaRepository<Pessoa, Long>{

}
