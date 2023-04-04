package com.servico.backservice.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.servico.backservice.domain.model.Servico;
import com.servico.backservice.domain.repository.ServicoRepository;

@Service
public class ServicoService {
	
	@Autowired
	private ServicoRepository servicoRepository;
	
	
	public List<Servico> buscarTodos(){
		return servicoRepository.findAll();
	}
	
	public List<Servico> buscarServicoPagamentoPendente(){
		return servicoRepository.buscarServicosPagamentoPendente();
	}
	
	public List<Servico> nuscarServicoCancelado(){
		return servicoRepository.buscarServicoCanceldo();
	}
	
	public Servico inserir(Servico servico) {
		if(servico.getValorPago() == null || servico.getValorPago() == 0 || servico.getDataPagamento() == null) {
			servico.setStatus("pendente");
	}else {
		servico.setStatus("realizado");
		
	}
		return servicoRepository.save(servico);
	}
	
	public Servico alterar(Servico servico) {
		if(servico.getValorPago()!= null && servico.getValorPago() > 0 && servico.getDataPagamento() != null) {
			servico.setStatus("realizado");
		}	
		return servicoRepository.saveAndFlush(servico);
	}
	
	public Servico cancelar(Long id){
		Servico servico = servicoRepository.findById(id).get();
		servico.setStatus("cancelado");
		servicoRepository.saveAndFlush(servico);
		return servico;
	}
	
	public void excluir(Long id) {
		Servico servico = servicoRepository.findById(id).get();
		servicoRepository.delete(servico);
	}
}
