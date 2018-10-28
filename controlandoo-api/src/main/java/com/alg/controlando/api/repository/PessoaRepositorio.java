package com.alg.controlando.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alg.controlando.api.models.Pessoa;

public interface PessoaRepositorio extends JpaRepository<Pessoa, Long>{

}
