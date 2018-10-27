package com.alg.controlando.api.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alg.controlando.api.models.Lancamento;

public interface LancamentoRepository extends JpaRepository<Lancamento, Long>{

}
