package com.alg.controlando.api.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.alg.controlando.api.models.Pessoa;
import com.alg.controlando.api.repository.PessoaRepositorio;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepositorio pessoaRepository;
	
	public Pessoa atualizar(Long id,Pessoa pessoa) {
		Pessoa pessoaSalva = buscarPessoaPorID(id);
		BeanUtils.copyProperties(pessoa, pessoaSalva, "id");
		return pessoaRepository.save(pessoaSalva);		
	
	}

	public void atualizarPropriedadeAtivo(Long id, Boolean ativo) {
		Pessoa pessoa =  buscarPessoaPorID(id);
		pessoa.setAtivo(ativo);
		pessoaRepository.save(pessoa);
	}
	
	public Pessoa buscarPessoaPorID(Long id) {
		Pessoa pessoaSalva = pessoaRepository.findOne(id);
		if (pessoaSalva == null) throw new EmptyResultDataAccessException(1);
		return pessoaSalva;
	}
	
}
