package com.alg.controlando.api.resource;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.alg.controlando.api.event.RecursoCriadoEvent;
import com.alg.controlando.api.models.Categoria;
import com.alg.controlando.api.repository.ICategoria;
import com.alg.controlando.api.service.CategoriaService;


@RestController
@RequestMapping("/categorias") 
public class CategoriaResource {

	@Autowired 
	private ICategoria categoriaRepository;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@Autowired
	private CategoriaService service;
	
	@GetMapping
	public List<Categoria> listarTodos() {
		return categoriaRepository.findAll();
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Categoria> criar(@Valid @RequestBody Categoria categoria, HttpServletResponse response) {
		Categoria categoriaSalva = categoriaRepository.save(categoria);
		publisher.publishEvent(new RecursoCriadoEvent(this,response, categoria.geCodigo()));
		return ResponseEntity.status(HttpStatus.CREATED).body(categoriaSalva);
	}

	
	@GetMapping("/{codigo}")
	public ResponseEntity<Categoria> buscarId(@PathVariable Long codigo) {
		Categoria categoria = categoriaRepository.findOne(codigo);
		return categoria !=  null ? ResponseEntity.ok(categoria) : ResponseEntity.notFound().build();
		}
	
	@PutMapping("/{codigo}")
	public ResponseEntity<Categoria> atualizar(@PathVariable Long codigo ,@Valid @RequestBody Categoria categoria){
		Categoria categoriaSalvar = service.atualizar(codigo, categoria);
		return ResponseEntity.ok(categoriaSalvar);
	}

}
