package com.itau.desafio.service;

import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.itau.desafio.model.Transacao;

@Service
public class TransacaoService {
	
private static List<Transacao> transacoes;
	
	public TransacaoService() {
		
	
		transacoes = new ArrayList<Transacao>(); 
		
		Transacao transacao = new Transacao(); 
		transacao.setValor(2);
		transacoes.add(transacao);
		
		transacao = new Transacao(); 
		transacao.setValor(1);
		transacoes.add(transacao);
		
		DoubleSummaryStatistics analiseDeTransacoes = transacoes.stream()
				.collect(Collectors.summarizingDouble(Transacao::getValor));
		System.out.println("Analise de transações : " + analiseDeTransacoes);
	}
	
	public static List<Transacao> listaDeTransacoes(){
		return analiseDeTransacoes;
	}
	
}
