package com.alg.controlando.api.repository.lancamento;



import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.alg.controlando.api.models.Lancamento;
import com.alg.controlando.api.repository.filter.LancamentoFilter;

public interface LancamentoRepositoryQuery  {

	
	public Page<Lancamento> filtrar(LancamentoFilter lancamentoFilter, Pageable pageable);
}
