package com.junior.projects.backendproject.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.junior.projects.backendproject.model.TipoAplicacaoPermitido;

public interface ITipoAplicacaoPermitidoDAO extends JpaRepository<TipoAplicacaoPermitido, Integer> {
	public TipoAplicacaoPermitido findByNomeTipoAplicacao(String nomeTipoAplicacao);
}
