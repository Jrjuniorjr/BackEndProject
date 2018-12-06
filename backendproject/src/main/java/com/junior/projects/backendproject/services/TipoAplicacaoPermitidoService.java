package com.junior.projects.backendproject.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.junior.projects.backendproject.dao.ITipoAplicacaoPermitidoDAO;
import com.junior.projects.backendproject.formatosenvio.TipoAplicacaoFormatoEnvio;
import com.junior.projects.backendproject.model.*;

public class TipoAplicacaoPermitidoService {
	
	@Autowired
	ITipoAplicacaoPermitidoDAO iTipoAplicacaoPermitidoDAO;
	
	@Autowired
	OperadorService operadorService;
	
	public ResponseEntity salvarTipoAplicacaoPermitido(TipoAplicacaoFormatoEnvio tipoAplicacaoFormatoEnvio) {
		Operador administrador = operadorService.consultarOperadorPorCodigo(tipoAplicacaoFormatoEnvio.getCodigoAdministrador());
		if(administrador == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		else {
			if(administrador.getTipoFuncionario().equals(TipoFuncionario.Operador)) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
			}
			else {
				iTipoAplicacaoPermitidoDAO.save(tipoAplicacaoFormatoEnvio.getTipoAplicacaoPermitido());
				return ResponseEntity.ok("Sucesso");
			}
		}
	}
	
	public List<TipoAplicacaoPermitido> listarTodostiposAplicacaoPermitidos(){
		return iTipoAplicacaoPermitidoDAO.findAll();
	}
	
}
