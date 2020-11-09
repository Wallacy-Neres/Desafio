package com.itau.desafio.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itau.desafio.model.Transacao;

@Service
public class EstatisticaService {

	@Autowired
    protected TransacaoService service;
	
	public DoubleSummaryStatistics estatistica() {
		List<Transacao> listaTransacao = service.listaDeTransacoes();
		
		List<Transacao> dentroDeUmMinuto = new ArrayList<>();
		
		tratarAsTransacoes(listaTransacao, dentroDeUmMinuto);
		
		DoubleSummaryStatistics analiseDeTransacoes = dentroDeUmMinuto.stream()
				.collect(Collectors.summarizingDouble(Transacao::getValor));
			
			return analiseDeTransacoes;
	}

	protected void tratarAsTransacoes(List<Transacao> listaTransacao, List<Transacao> dentroDeUmMinuto) {
		LocalDateTime horaComMinutoaMenos = LocalDateTime.now().minusSeconds(60);
		
		for(int i =0; i < listaTransacao.size(); i++) {
			if(listaTransacao.get(i).getHoraDoSitema().isAfter(horaComMinutoaMenos)) {
				dentroDeUmMinuto.add(listaTransacao.get(i));
			}
		}
	}
	
}
