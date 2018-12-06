package com.junior.projects.backendproject.model;

import javax.persistence.*;

import lombok.*;

@Entity()
@Table(name = "tipoArquivoPermitido")
public class TipoArquivoPermitido {

	@Id 
	@Column (name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column (name = "nomeTipoArquivoPermitido")
	private String nomeTipoArquivoPermitido;
	
	@Enumerated(EnumType.STRING)
	@Column(name="tipo", columnDefinition="enum('Ativo', 'Inativo')")
	private StatusAtivacao statusAtivacao;

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

	public StatusAtivacao getStatusAtivacao() {
		return statusAtivacao;
	}

	public void setStatusAtivacao(StatusAtivacao statusAtivacao) {
		this.statusAtivacao = statusAtivacao;
	}

	
}
