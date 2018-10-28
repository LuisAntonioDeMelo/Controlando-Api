package com.alg.controlando.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alg.controlando.api.models.Lancamento;
import com.alg.controlando.api.repository.lancamento.LancamentoRepositoryQuery;

public interface LancamentoRepository extends JpaRepository<Lancamento, Long>, LancamentoRepositoryQuery {

}
