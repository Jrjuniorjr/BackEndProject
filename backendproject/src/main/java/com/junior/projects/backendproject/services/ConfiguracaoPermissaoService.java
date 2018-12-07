package com.junior.projects.backendproject.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.junior.projects.backendproject.formatosenvio.ConfiguracaoPermissaoFormatoEnvio;
import com.junior.projects.backendproject.formatosenvio.OperadorFormatoEnvio;
import com.junior.projects.backendproject.model.*;

public class ConfiguracaoPermissaoService {

	@Autowired
	private OperadorService operadorService;
	
	public ResponseEntity adicionarPermissao(ConfiguracaoPermissaoFormatoEnvio permissaoObject) {
		
		Operador operador = operadorService.
				consultarOperadorPorCodigo(permissaoObject.getCodigoOperador());
		
		Operador administrador = operadorService.
				consultarOperadorPorCodigo(permissaoObject.getCodigoAdministrador());
		
		if(operador == null || administrador == null) {
			
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		
		}
		
		else {
			
			if(administrador.getTipoFuncionario().equals(TipoFuncionario.Operador)) {
			
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
			
			}
			
			else {
				operador.setTiposArquivosPermitidos(permissaoObject.getTiposArquivosPermitidos());
				
				operador.setTipoAplicacaoPermitidos(permissaoObject.getTipoAplicacaoPermitidos());
				
				OperadorFormatoEnvio operadorFormatoEnvio = new OperadorFormatoEnvio();
				
				operadorFormatoEnvio.setCodigoAdministrador(administrador.getCodigo());
				
				operadorFormatoEnvio.setOperador(operador);
				
				return operadorService.salvarOperador(operadorFormatoEnvio);
			}
		}
	}
}
