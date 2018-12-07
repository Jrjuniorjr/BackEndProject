package com.junior.projects.backendproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.junior.projects.backendproject.dao.IOperadorDAO;
import com.junior.projects.backendproject.model.Operador;
import com.junior.projects.backendproject.model.TipoFuncionario;

@SpringBootApplication
public class BackendprojectApplication implements CommandLineRunner {
	
	@Autowired
	IOperadorDAO iOperadorDAO;
	
	public static void main(String[] args) {
		SpringApplication.run(BackendprojectApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
	
		Operador administrador = new Operador();
		administrador.setCodigo("0000");
		administrador.setTipoFuncionario(TipoFuncionario.Administrador);
		iOperadorDAO.save(administrador);
	}
	
}
