package com.alg.controlando.api.resource;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.alg.controlando.api.event.RecursoCriadoEvent;
import com.alg.controlando.api.models.Lancamento;
import com.alg.controlando.api.repositorio.LancamentoRepository;

@RestController
@RequestMapping("lancamentos")
public class LancamentoResource {
	
	@Autowired
	private LancamentoRepository lancamentoRepository;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@GetMapping
	public List<Lancamento> getLancamentos(){
		return lancamentoRepository.findAll();
	}
	
	@GetMapping("/{idLancamento}")
	public ResponseEntity<Lancamento> getId(@PathVariable Long idLancamento){
		Lancamento lancamento = lancamentoRepository.findOne(idLancamento);
		return lancamento != null ? ResponseEntity.ok(lancamento) : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	
	
	@PostMapping
	public ResponseEntity<Lancamento> criar(@Valid @RequestBody Lancamento lancamento, HttpServletResponse response){
		Lancamento lancamentoSalvo = lancamentoRepository.save(lancamento);
		publisher.publishEvent(new RecursoCriadoEvent(this,response,lancamento.getIdLancamento()));
		return ResponseEntity.status(HttpStatus.CREATED).body(lancamentoSalvo);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void  delete(@PathVariable Long id){
		lancamentoRepository.delete(id);
	}
	
	
	
	
}
