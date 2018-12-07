package com.junior.projects.backendproject.model;

import javax.persistence.*;


@Entity()
@Table(name = "tipoArquivoPermitido")
public class TipoArquivoPermitido {

	@Id 
	@Column (name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column (name = "nomeTipoArquivoPermitido")
	private String nomeTipoArquivoPermitido;
	

	@JoinColumn(name = "idArquivo")
	private Integer idArquivo;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomeTipoArquivoPermitido() {
		return nomeTipoArquivoPermitido;
	}

	public void setNomeTipoArquivoPermitido(String nomeTipoArquivoPermitido) {
		this.nomeTipoArquivoPermitido = nomeTipoArquivoPermitido;
	}	

	public Integer getIdArquivo() {
		return idArquivo;
	}

	public void setIdArquivo(Integer idArquivo) {
		this.idArquivo = idArquivo;
	}

	
}
