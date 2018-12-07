package com.junior.projects.backendproject.formatosenvio;

import com.junior.projects.backendproject.model.TipoAplicacaoPermitido;

public class TipoAplicacaoFormatoEnvio {
	private String codigoAdministrador;
	private TipoAplicacaoPermitido tipoAplicacaoPermitido;
	
	public String getCodigoAdministrador() {
		return codigoAdministrador;
	}
	public void setCodigoAdministrador(String codigoAdministrador) {
		this.codigoAdministrador = codigoAdministrador;
	}
	public TipoAplicacaoPermitido getTipoAplicacaoPermitido() {
		return tipoAplicacaoPermitido;
	}
	public void setTipoAplicacaoPermitido(TipoAplicacaoPermitido tipoAplicacaoPermitido) {
		this.tipoAplicacaoPermitido = tipoAplicacaoPermitido;
	}
	
	
}
