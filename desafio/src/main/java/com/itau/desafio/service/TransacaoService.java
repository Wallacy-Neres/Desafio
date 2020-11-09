package com.itau.desafio.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.itau.desafio.exception.TransacaoNaoPodeAcontecerNoFuturoException;
import com.itau.desafio.model.Transacao;

@Service
public class TransacaoService {

	protected List<Transacao> transacoes;

	public void instanciarLista() {
		if (transacoes == null) 
			transacoes = new ArrayList<>();
	}

	public void SalvarTransacao(Transacao transacao) throws TransacaoNaoPodeAcontecerNoFuturoException {
		if (transacao.getDataHora().isAfter(LocalDateTime.now()))
			throw new TransacaoNaoPodeAcontecerNoFuturoException("A Transação não deve ocorrer no futuro");

		instanciarLista();
		transacoes.add(transacao);
	}

	public List<Transacao> listaDeTransacoes() {
		return transacoes;
	}

	public void deletarTransacoes() {
		transacoes.clear();
	}
}
