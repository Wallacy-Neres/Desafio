package com.itau.desafio.model;

import java.time.OffsetDateTime;


public class Transacao {
		
	private int valor;
	
	private OffsetDateTime dataHora = OffsetDateTime.now();

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	public OffsetDateTime getDataHora() {
		return dataHora;
	}

	public void setDataHora(OffsetDateTime dataHora) {
		this.dataHora = dataHora;
	}

	
	
}
