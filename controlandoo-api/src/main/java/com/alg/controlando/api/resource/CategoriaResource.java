package com.alg.controlando.api.resource;

import java.net.URI;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.alg.controlando.api.models.Categoria;
import com.alg.controlando.api.repositorio.ICategoria;

//aqui e o controlador do modelo rest
@RestController
@RequestMapping("/categorias") // nome da entidade na requisição usamos essa classe utilizando as categorias 
public class CategoriaResource {

	@Autowired // a injeção de dependencias do spring
	private ICategoria categoriaRepository;

	// anotação usa o get para todas requisições que utilizagem categoria ira listar
	// todas as categorias salvas no banco
	// sendo assim ele retorna todas as categorias do repositorio
	@GetMapping
	public List<Categoria> listarTodos() {
		return categoriaRepository.findAll();
	}

	// no post usamos para postar ou seja irá postar/salvar todos os dados inseridos
	// no java
	// aqui tbm usamos a anotação responseStatus que contém o tipo de requisão feita
	// no protocolo http contém o created que é 201

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Categoria> criar(@Valid @RequestBody Categoria categoria, HttpServletResponse response) {
		Categoria categoriaSalva = categoriaRepository.save(categoria);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{codigo}")
				.buildAndExpand(categoria.geCodigo()).toUri();
		response.setHeader("Location", uri.toASCIIString());

		return ResponseEntity.created(uri).body(categoriaSalva);
	}

	@SuppressWarnings("unchecked")
	@GetMapping("{codigo}")
	public ResponseEntity<Categoria> buscarId(@PathVariable Long codigo) {
		if(codigo != null && !categoriaRepository.findOne(codigo).equals(null) ) {
		System.out.println("Encontrado");
		return ResponseEntity.ok(categoriaRepository.findOne(codigo)) ;
		}
		System.out.println("Não encontrado");
		return (ResponseEntity<Categoria>) ResponseEntity.status(HttpStatus.NOT_FOUND);
	}

}
