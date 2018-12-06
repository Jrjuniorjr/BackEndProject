package com.junior.projects.backendproject.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.junior.projects.backendproject.dao.ITipoArquivoPermitidoDAO;
import com.junior.projects.backendproject.formatosenvio.TipoArquivoFormatoEnvio;
import com.junior.projects.backendproject.model.*;

public class TipoArquivoPermitidoService {
	@Autowired
	ITipoArquivoPermitidoDAO iTipoArquivoPermitidoDAO;
	
	@Autowired
	OperadorService operadorService;
	
	public ResponseEntity salvarTipoArquivoPermitido(TipoArquivoFormatoEnvio tipoArquivoFormatoEnvio) {
		Operador administrador = operadorService.consultarOperadorPorCodigo(tipoArquivoFormatoEnvio.getCodigoAdministrador());
		if(administrador == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		else {
			if(administrador.getTipoFuncionario().equals(TipoFuncionario.Operador)) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
			}
			else {
				iTipoArquivoPermitidoDAO.save(tipoArquivoFormatoEnvio.getTipoArquivoPermitido());
				return ResponseEntity.ok("Sucesso");
			}
		}
	}
	
	public List<TipoArquivoPermitido> listarTodostiposArquivosPermitidos(){
		return iTipoArquivoPermitidoDAO.findAll();
	}
}
