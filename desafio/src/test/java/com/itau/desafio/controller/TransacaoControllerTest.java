package com.itau.desafio.controller;

import java.time.LocalDateTime;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.itau.desafio.model.Transacao;
import com.itau.desafio.service.TransacaoService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TransacaoControllerTest {

	@Autowired
	private TransacaoService transacaoService;
	
	@Autowired
	public WebApplicationContext context;
	
	private MockMvc mvc;
	
	@Before
	public void setup() {
		this.mvc = MockMvcBuilders.webAppContextSetup(this.context).build();
	}
	
	@Test
	public void listarTransacaoTest() throws Exception {
		this.mvc.perform(MockMvcRequestBuilders.get("/listar"))
						.andExpect(MockMvcResultMatchers.status().isOk());					
	}
	
	@Test
	public void criarTransacaoTest() throws Exception {
		Transacao transacao = new Transacao();
		transacao.setValor(400.00);
		transacao.setDataHora(LocalDateTime.now());
		
		ObjectMapper mapper = new ObjectMapper();
	
		String json = mapper.writeValueAsString(transacao);
		
		this.mvc.perform(MockMvcRequestBuilders
			      .post("/transacao")
			      .contentType(MediaType.APPLICATION_JSON)
			      .accept(MediaType.APPLICATION_JSON)
			      .contentType(json));		  
	}
	
	@Test
	public void deletarTransacao() throws Exception {
		
		if(transacaoService.listaDeTransacoes() == null) {
			this.mvc.perform(MockMvcRequestBuilders.delete("/transacao"))
			.andExpect(MockMvcResultMatchers.status().is4xxClientError());
		}else {
			this.mvc.perform(MockMvcRequestBuilders.delete("/transacao"))
			.andExpect(MockMvcResultMatchers.status().isNoContent());
		}				
	}
}
