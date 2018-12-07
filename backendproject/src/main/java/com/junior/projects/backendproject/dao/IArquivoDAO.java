package com.junior.projects.backendproject.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.junior.projects.backendproject.model.Arquivo;

public interface IArquivoDAO extends JpaRepository<Arquivo, Integer>{

	public Arquivo findByNomeArquivo(String nomeArquivo);
}
