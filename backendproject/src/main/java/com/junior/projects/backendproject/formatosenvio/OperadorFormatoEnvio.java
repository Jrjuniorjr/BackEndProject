package com.junior.projects.backendproject.formatosenvio;

import com.junior.projects.backendproject.model.Operador;
import com.junior.projects.backendproject.model.TipoAplicacaoPermitido;

public class OperadorFormatoEnvio {
	private String codigoAdministrador;
	private Operador operador;
	
	public String getCodigoAdministrador() {
		return codigoAdministrador;
	}
	public void setCodigoAdministrador(String codigoAdministrador) {
		this.codigoAdministrador = codigoAdministrador;
	}
	public Operador getOperador() {
		return operador;
	}
	public void setOperador(Operador operador) {
		this.operador = operador;
	}
}
