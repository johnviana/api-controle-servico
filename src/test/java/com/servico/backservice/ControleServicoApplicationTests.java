package com.servico.backservice;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.servico.backservice.domain.model.Servico;
import com.servico.backservice.domain.service.ServicoService;

@SpringBootTest
class ControleServicoApplicationTests {

	@Autowired
	private ServicoService cadastroService;
	
	@Test
	public void cadastro_servico_com_nome() {
		
		Servico novaServico = new Servico();
		novaServico.setNomeCliente("");
		
		novaServico = cadastroService.inserir(novaServico);
		
		assertThat(novaServico).isNotNull();
		assertThat(novaServico.getId()).isNotNull();
	}
	
	@Test
	public void cadastro_de_servico_sem_Nome() {
		
		Servico novoServico = new Servico();
		novoServico.setNomeCliente(null);
		
		novoServico = cadastroService.inserir(novoServico);
			
	}
	
	
}
