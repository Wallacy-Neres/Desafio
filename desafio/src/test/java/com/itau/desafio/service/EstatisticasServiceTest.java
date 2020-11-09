package com.itau.desafio.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import com.itau.desafio.exception.TransacaoNaoPodeAcontecerNoFuturoException;
import com.itau.desafio.model.Transacao;

public class EstatisticasServiceTest {

	@InjectMocks @Spy
	private EstatisticaService estatisticasService;

	@Spy
	private TransacaoService service;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}
	
	//@Test
	public void deve_devolver_as_estatisticas() throws TransacaoNaoPodeAcontecerNoFuturoException {
		Transacao transacao = new Transacao();
		transacao.setDataHora(LocalDateTime.now());
		estatisticasService.service.SalvarTransacao(transacao);
		
		DoubleSummaryStatistics estatisticas = estatisticasService.estatistica();
		
		Assert.assertEquals(1, estatisticas.getCount());
		
	}
	
	@Test
	public void deve_retornar_a_lista_tratada() {
		List<Transacao> listaTransacoes = new ArrayList<>();
		List<Transacao> listaTransacoesTratada = new ArrayList<>();
		
		Transacao transacao = new Transacao();
		transacao.setDataHora(LocalDateTime.now());
		transacao.setHoraDoSitema(LocalDateTime.now().minusSeconds(120));
		
		Transacao transacao2 = new Transacao();
		transacao2.setDataHora(LocalDateTime.now());
		transacao2.setHoraDoSitema(LocalDateTime.now().minusSeconds(120));
		
		Transacao transacao3 = new Transacao();
		transacao3.setDataHora(LocalDateTime.now());
		
		listaTransacoes.add(transacao);
		listaTransacoes.add(transacao2);
		listaTransacoes.add(transacao3);
		
		estatisticasService.tratarAsTransacoes(listaTransacoes, listaTransacoesTratada);
		
		Assert.assertEquals(1, listaTransacoesTratada.size());
		
	}
	
}
