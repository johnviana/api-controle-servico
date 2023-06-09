package com.servico.backservice.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.servico.backservice.domain.model.Servico;

@Repository
public interface ServicoRepository extends JpaRepository<Servico, Long>{
	
	@Query("select s from Servico s where s.valorPago is null or s.valorPago = 0")
	List<Servico> buscarServicosPagamentoPendente();
	
	@Query("select s from Servico s where s.status = 'cancelado' ")
	List<Servico> buscarServicoCanceldo();

}
