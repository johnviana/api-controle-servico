package com.servico.backservice.domain.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.servico.backservice.domain.model.Servico;
import com.servico.backservice.domain.service.ServicoService;

@RestController
@RequestMapping(value = "/api/servico")
public class ServicoController {
	
	@Autowired
	private ServicoService servicoService;
	
	@GetMapping("/")
	public List<Servico> buscartodos(){
		return servicoService.buscarTodos();
		
	}
	
	@GetMapping("/pendente")
	public List<Servico> buscarServicoPagamentoPendente(){
		return servicoService.buscarServicoPagamentoPendente();
	}
	
	@GetMapping("/cancelado")
	public List<Servico> buscarServicoCancelado(){
		return servicoService.nuscarServicoCancelado();
		
	}
	
	@PostMapping("/")
	public Servico cadastrar(@RequestBody Servico servico) {
		return servicoService.inserir(servico);
	}
	
	@PutMapping("/altera")
	public Servico alterar(@RequestBody Servico servico) {
		return servicoService.alterar(servico);
		
	}
	
	@PostMapping("/{id}")
	public ResponseEntity<Service> cancelar(@PathVariable Long id){
		servicoService.cancelar(id);
		return ResponseEntity.ok().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> remover(@PathVariable Long id){
		servicoService.excluir(id);
		return ResponseEntity.ok().build();
		
	}
	
	

}
