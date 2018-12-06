package com.junior.projects.backendproject.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.junior.projects.backendproject.model.Operador;

public interface IOperadorDAO extends JpaRepository<Operador, Integer>{
	public Operador findByCodigo(String codigo);
}
