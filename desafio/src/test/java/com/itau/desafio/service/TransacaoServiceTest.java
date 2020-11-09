package com.itau.desafio.service;

import java.time.LocalDateTime;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import com.itau.desafio.exception.TransacaoNaoPodeAcontecerNoFuturoException;
import com.itau.desafio.model.Transacao;


public class TransacaoServiceTest {
	
	@InjectMocks
	private TransacaoService service;
	
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void deve_instanciar_lista() {
		service.instanciarLista();
		Assert.assertNotNull(service.transacoes);
	}
	
	@Test
	public void deve_salvar_transacao() throws TransacaoNaoPodeAcontecerNoFuturoException {
		Transacao transacao = new Transacao();
		transacao.setDataHora(LocalDateTime.now());
		
		
		service.SalvarTransacao(transacao);
		
		Assert.assertEquals(1, service.transacoes.size());
	}
	
	@Test(expected = TransacaoNaoPodeAcontecerNoFuturoException.class)
	public void deve_devolver_erro_transacao_no_futuro() throws TransacaoNaoPodeAcontecerNoFuturoException {
		Transacao transacao = new Transacao();
		transacao.setDataHora(LocalDateTime.now().plusMinutes(1));
		
		service.SalvarTransacao(transacao);
	}

	
	@Test
	public void deve_deletar_transacoes() throws TransacaoNaoPodeAcontecerNoFuturoException {
		Transacao transacao = new Transacao();
		transacao.setDataHora(LocalDateTime.now());
		
		
		service.SalvarTransacao(transacao);
		service.deletarTransacoes();
		
		Assert.assertEquals(0, service.transacoes.size());
		
	}
}
