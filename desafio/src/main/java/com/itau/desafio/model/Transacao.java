package com.itau.desafio.model;


import java.time.LocalDateTime;

import javax.validation.constraints.Min;

import com.fasterxml.jackson.annotation.JsonIgnore;


public class Transacao {
	
	@Min(value = 0)
	private Double valor;
	
	private LocalDateTime dataHora;
	
	@JsonIgnore
	private LocalDateTime horaDoSitema = LocalDateTime.now();

	public LocalDateTime getHoraDoSitema() {
		return horaDoSitema;
	}

	public void setHoraDoSitema(LocalDateTime horaDoSitema) {
		this.horaDoSitema = horaDoSitema;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public LocalDateTime getDataHora() {
		return dataHora;
	}

	public void setDataHora(LocalDateTime dataHora) {
		this.dataHora = dataHora;
	}

	

	
	
}
