package com.alg.controlando.api.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.alg.controlando.api.models.Categoria;
import com.alg.controlando.api.repository.ICategoria;

@Service
public class CategoriaService {
	
	@Autowired
	private ICategoria categoriaRepository;
	
	public Categoria atualizar(Long id , Categoria categoria) {
		Categoria categoriaSalva = buscaCategoriaID(id);
		BeanUtils.copyProperties(categoria, categoriaSalva,"id");
		return categoriaRepository.save(categoriaSalva);
	}
	
	
	private Categoria buscaCategoriaID(Long id) {
		Categoria categoriaFound = categoriaRepository.findOne(id);
		if(categoriaFound == null) throw new EmptyResultDataAccessException(1);
		return categoriaFound;
	}

}
