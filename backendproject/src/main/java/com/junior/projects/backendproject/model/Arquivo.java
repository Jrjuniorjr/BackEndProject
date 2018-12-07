package com.junior.projects.backendproject.model;

import java.sql.Date;
import java.time.LocalTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity()
@Table(name = "Arquivo")
public class Arquivo {
	
	@Id 
	@Column (name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "dataEnvio")
	private LocalTime dataEnvio;
	
	@OneToOne(cascade=
			CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private TipoArquivoPermitido tipoArquivoPermitido;
	
	@Column(name = "arquivoBytes")
	@Lob
	private byte[] arquivoBytes;
	
	@Column(name = "nomeArquivo")
	private String nomeArquivo;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalTime getDataEnvio() {
		return dataEnvio;
	}

	public void setDataEnvio(LocalTime dataEnvio) {
		this.dataEnvio = dataEnvio;
	}

	public TipoArquivoPermitido getTipoArquivoPermitido() {
		return tipoArquivoPermitido;
	}

	public void setTipoArquivoPermitido(TipoArquivoPermitido tipoArquivoPermitido) {
		this.tipoArquivoPermitido = tipoArquivoPermitido;
	}

	public byte[] getArquivoBytes() {
		return arquivoBytes;
	}

	public void setArquivoBytes(byte[] arquivoBytes) {
		this.arquivoBytes = arquivoBytes;
	}

	public String getNomeArquivo() {
		return nomeArquivo;
	}

	public void setNomeArquivo(String nomeArquivo) {
		this.nomeArquivo = nomeArquivo;
	}

	
	
	
}
