package com.junior.projects.backendproject.formatosenvio;

import java.util.List;

import com.junior.projects.backendproject.model.TipoAplicacaoPermitido;
import com.junior.projects.backendproject.model.TipoArquivoPermitido;

import lombok.*;

public class ConfiguracaoPermissaoFormatoEnvio {
	
	private String codigoOperador;
	private String codigoAdministrador;
	private List<TipoAplicacaoPermitido> tipoAplicacaoPermitidos;
	private List<TipoArquivoPermitido> tiposArquivosPermitidos;
	
	public String getCodigoOperador() {
		return codigoOperador;
	}
	public void setCodigoOperador(String codigoOperador) {
		this.codigoOperador = codigoOperador;
	}
	public String getCodigoAdministrador() {
		return codigoAdministrador;
	}
	public void setCodigoAdministrador(String codigoAdministrador) {
		this.codigoAdministrador = codigoAdministrador;
	}
	public List<TipoAplicacaoPermitido> getTipoAplicacaoPermitidos() {
		return tipoAplicacaoPermitidos;
	}
	public void setTipoAplicacaoPermitidos(List<TipoAplicacaoPermitido> tipoAplicacaoPermitidos) {
		this.tipoAplicacaoPermitidos = tipoAplicacaoPermitidos;
	}
	public List<TipoArquivoPermitido> getTiposArquivosPermitidos() {
		return tiposArquivosPermitidos;
	}
	public void setTiposArquivosPermitidos(List<TipoArquivoPermitido> tiposArquivosPermitidos) {
		this.tiposArquivosPermitidos = tiposArquivosPermitidos;
	}
    

	
}
