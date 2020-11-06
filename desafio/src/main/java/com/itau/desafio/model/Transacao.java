package com.itau.desafio.model;

import java.time.OffsetDateTime;


public class Transacao {
		
	private String valor;
	
	private OffsetDateTime dataHora = OffsetDateTime.now();

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public OffsetDateTime getDataHora() {
		return dataHora;
	}

	public void setDataHora(OffsetDateTime dataHora) {
		this.dataHora = dataHora;
	}
	
}
