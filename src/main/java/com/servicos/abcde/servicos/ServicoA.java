package com.servicos.abcde.servicos;


import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.servicos.abcde.entidades.A;
import com.servicos.abcde.repositorios.RepositorioA;
import com.servicos.abcde.servicos.excecoes.ObjetoNaoEncontradoException;

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
		return obj.orElseThrow(() -> new ObjetoNaoEncontradoException(id));
	}
	
	public A inserir(A a) {
		return repositorio.save(a);
	}
	
	public void excluir(Long id) {
		try {
			repositorio.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ObjetoNaoEncontradoException(id);
		}
	}
	
	public A update(Long id, A objeto_alterado) {
		try {
			A a = repositorio.getById(id);
			atualizarDados(a, objeto_alterado);
			return repositorio.save(a);	
		}catch (EntityNotFoundException e) {
			throw new ObjetoNaoEncontradoException(id);
		}

	}
	
	public void atualizarDados(A destino, A origem) {
		destino.setAtributo1(origem.getAtributo1());
		destino.setAtributo2(origem.getAtributo2());
		destino.setAtributo3(origem.getAtributo3());
		destino.setAtributo4(origem.getAtributo4());
	}
}

