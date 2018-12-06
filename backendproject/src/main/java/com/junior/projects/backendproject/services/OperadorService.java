package com.junior.projects.backendproject.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.junior.projects.backendproject.dao.IOperadorDAO;
import com.junior.projects.backendproject.formatosenvio.OperadorFormatoEnvio;
import com.junior.projects.backendproject.formatosenvio.TipoAplicacaoFormatoEnvio;
import com.junior.projects.backendproject.model.Operador;
import com.junior.projects.backendproject.model.TipoFuncionario;

public class OperadorService {
	
	@Autowired
	private IOperadorDAO iOperadorDAO;
	
	public Operador consultarOperadorPorCodigo(String codigo) {
		return iOperadorDAO.findByCodigo(codigo);
	}
	
	public ResponseEntity salvarOperador(OperadorFormatoEnvio operadorFormatoEnvio) {
		Operador administrador = iOperadorDAO.findByCodigo(operadorFormatoEnvio.getCodigoAdministrador());
		if(administrador == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		else {
			if(administrador.getTipoFuncionario().equals(TipoFuncionario.Operador)) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
			}
			else {
				iOperadorDAO.save(operadorFormatoEnvio.getOperador());
				return ResponseEntity.ok("Sucesso");
			}
		}
	}
	
}
