package com.junior.projects.backendproject.formatosenvio;

import com.junior.projects.backendproject.model.TipoArquivoPermitido;

public class TipoArquivoFormatoEnvio {

	private String codigoAdministrador;
	private TipoArquivoPermitido tipoArquivoPermitido;
	public String getCodigoAdministrador() {
		return codigoAdministrador;
	}
	public void setCodigoAdministrador(String codigoAdministrador) {
		this.codigoAdministrador = codigoAdministrador;
	}
	public TipoArquivoPermitido getTipoArquivoPermitido() {
		return tipoArquivoPermitido;
	}
	public void setTipoArquivoPermitido(TipoArquivoPermitido tipoArquivoPermitido) {
		this.tipoArquivoPermitido = tipoArquivoPermitido;
	}
	
	
}
