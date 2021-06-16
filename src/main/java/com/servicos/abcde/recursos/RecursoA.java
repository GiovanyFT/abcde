package com.servicos.abcde.recursos;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.servicos.abcde.entidades.A;
import com.servicos.abcde.servicos.ServicoA;

@RestController
@RequestMapping(value = "/as")
public class RecursoA {
	
	@Autowired
	private ServicoA servico;
	
	@GetMapping
	public ResponseEntity<List<A>> obterTodos(){
		List<A> lista = servico.obterTodos();
		return ResponseEntity.ok().body(lista);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<A> obterPorId(@PathVariable Long id){
		A a = servico.obterPorId(id);
		return ResponseEntity.ok().body(a);
	}
	
	@PostMapping
	public ResponseEntity<A> inserir(@RequestBody A a){
		a = servico.inserir(a);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().
				path("/{id}").buildAndExpand(a.getId()).toUri();
		return ResponseEntity.created(uri).body(a);
	}
}

