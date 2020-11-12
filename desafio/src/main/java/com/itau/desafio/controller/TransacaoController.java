package com.itau.desafio.controller;


import java.util.DoubleSummaryStatistics;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itau.desafio.exception.TransacaoNaoPodeAcontecerNoFuturoException;
import com.itau.desafio.model.Transacao;
import com.itau.desafio.service.EstatisticaService;
import com.itau.desafio.service.TransacaoService;

@RestController
@RequestMapping("/")
@CrossOrigin("*")
public class TransacaoController {
	
	@Autowired
	private TransacaoService transacaoService;
	
	@Autowired
	private EstatisticaService estatisticaService;
	
	
	@GetMapping("/listar")
	public ResponseEntity<List<Transacao>> transacao(){
		return ResponseEntity.ok(transacaoService.listaDeTransacoes());
	}
	
	@GetMapping("/estatistica")
	public ResponseEntity<DoubleSummaryStatistics> estatistica(){
		return ResponseEntity.ok(estatisticaService.estatistica());
	}
	
	@PostMapping("/transacao")
	public ResponseEntity<?> Post(@RequestBody @Valid Transacao transacao) {
		
		try {
			transacaoService.SalvarTransacao(transacao);
			return ResponseEntity.status(HttpStatus.CREATED).body(null);
		} catch (TransacaoNaoPodeAcontecerNoFuturoException e) {
			e.printStackTrace();
			return ResponseEntity.unprocessableEntity().body(e.getMessage());
		}
		
	}
	
	@DeleteMapping("/transacao")
	public ResponseEntity<?> deletarTransacoes(){	
		
		if(transacaoService.listaDeTransacoes() == null) 
			return ResponseEntity.notFound().build();
		else {
			transacaoService.deletarTransacoes();
			return ResponseEntity.noContent().build();
		}
	}	
	
	
}
