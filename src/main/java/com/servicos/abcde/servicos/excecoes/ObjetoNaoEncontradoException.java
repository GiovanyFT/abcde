package com.servicos.abcde.servicos.excecoes;

// RuntimeException é uma exceção que o compilador não nos obriga tratar
public class ObjetoNaoEncontradoException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public ObjetoNaoEncontradoException(Object id) {
		super("Objeto não encontrado. ID = " + id);
	}
}


