package com.alg.controlando.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alg.controlando.api.exception.service.PessoaInexistenteOuInativaException;
import com.alg.controlando.api.models.Lancamento;
import com.alg.controlando.api.models.Pessoa;
import com.alg.controlando.api.repository.LancamentoRepository;

@Service
public class LancamentoService {

	@Autowired
	private PessoaService pessoaService;
	
	@Autowired
	private LancamentoRepository lancamentoRepository;
	
	public Lancamento salvar(Lancamento lancamento) {
		Pessoa pessoa = pessoaService.buscarPessoaPorID(lancamento.getPessoa().getIdPessoa());
		if(pessoa == null || pessoa.isInativo()) {
			throw new PessoaInexistenteOuInativaException();
		}

		return lancamentoRepository.save(lancamento);
	}
	
}
