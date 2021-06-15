package com.servicos.abcde.configuracao;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.servicos.abcde.entidades.A;
import com.servicos.abcde.repositorios.RepositorioA;

@Configuration
@Profile("test")
public class SemeadoraDadosTeste implements CommandLineRunner{
	
	@Autowired
	private RepositorioA repositorioA;

	@Override
	public void run(String... args) throws Exception {
		A a1 = new A(null, "Atributo 11", 7.77, Instant.now(), 7);
		A a2 = new A(null, "Atributo 12", 2.77, Instant.parse("2020-07-20T19:51:09Z"), 2);
		
		repositorioA.saveAll(Arrays.asList(a1, a2));
	}
}

