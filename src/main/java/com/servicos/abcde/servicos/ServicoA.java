package com.servicos.abcde.servicos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.servicos.abcde.entidades.A;
import com.servicos.abcde.repositorios.RepositorioA;

@Service
public class ServicoA {
	
	// Fazendo a Injeção de Dependência
	@Autowired
	private RepositorioA repositorio;
	
	public List<A> obterTodos(){
		return repositorio.findAll();
	}
	
	public A obterPorId(Long id) {
		Optional<A> obj = repositorio.findById(id);
		return obj.get();
	}
	
	public A inserir(A a) {
		return repositorio.save(a);
	}
}

