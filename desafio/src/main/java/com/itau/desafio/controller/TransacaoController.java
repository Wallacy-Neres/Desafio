package com.itau.desafio.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itau.desafio.model.Transacao;
import com.itau.desafio.service.TransacaoService;

@RestController
@RequestMapping("/")
@CrossOrigin("*")
public class TransacaoController {
	
	@Autowired
	private static TransacaoService transacaoService;
	
	@GetMapping("/estatistica")
	public List<Transacao> transacao(){
		return transacaoService.listaDeTransacoes();
	}
	
	@PostMapping("/transacao")
	public ResponseEntity<Transacao> Post(@RequestBody Transacao transacao){
		return ResponseEntity.status(HttpStatus.CREATED).body(transacao);
	}
	
}
