package com.servicos.abcde.recursos;

import java.time.Instant;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.servicos.abcde.entidades.A;

@RestController
@RequestMapping(value = "/as")
public class RecursoA {
	
	@GetMapping
	public ResponseEntity<A> obterTodos(){
		A a = new A(1L, "Atributo 1", 7.77, Instant.now(), 7);
		return ResponseEntity.ok().body(a);
	}
}
