package com.servico.backservice.domain.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "service")
public class Servico {
	
	@Id
	@EqualsAndHashCode.Include
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "nome_cliente")
	private String nomeCliente;
	
	@Temporal(TemporalType.DATE)
	@Column(name ="data_iniciao")
	private Date dataInicio = new Date();
	
	@Column (name = "data_termino") 
	private Date dataTermino;
	
	@Column(name = "descricao_servico")
	private String descricaoServico;
	
	@Column(name = "valor_servico")
	private Double varlorServico;
	
	@Column(name = "valor_pago")
	private Double valorPago;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "data_pagamento")
	private Date dataPagamento;
	
	private String status; //"pendente", "realizado, "cancelado ""
	
	
	

}
