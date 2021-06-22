package com.servicos.abcde.recursos.excecoes;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.servicos.abcde.servicos.excecoes.ObjetoNaoEncontradoException;

@ControllerAdvice
public class TratadorExcecoesRecursos {

	@ExceptionHandler(ObjetoNaoEncontradoException.class)
	public ResponseEntity<CorpoErroPadrao> objetoNaoEncontrado(ObjetoNaoEncontradoException erro, HttpServletRequest request){
		String error  = "Objeto não encontrado!!! ";
		HttpStatus status = HttpStatus.NOT_FOUND;
		CorpoErroPadrao corpoErroPadrao = new CorpoErroPadrao(Instant.now(), status.value(), error, erro.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(corpoErroPadrao);
	}
}
