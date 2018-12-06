package com.junior.projects.backendproject.model;

import javax.persistence.*;

import lombok.*;
@Entity()
@Table(name = "Operador")
public class TipoAplicacaoPermitido {
	@Id 
	@Column (name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column (name = "nomeTipoArquivoPermitido")
	private String nomeTipoAplicacao;
	
	@Enumerated(EnumType.STRING)
	@Column(name="tipo", columnDefinition="enum('Ativo', 'Inativo')")
	private StatusAtivacao statusAtivacao;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomeTipoAplicacao() {
		return nomeTipoAplicacao;
	}

	public void setNomeTipoAplicacao(String nomeTipoAplicacao) {
		this.nomeTipoAplicacao = nomeTipoAplicacao;
	}

	public StatusAtivacao getStatusAtivacao() {
		return statusAtivacao;
	}

	public void setStatusAtivacao(StatusAtivacao statusAtivacao) {
		this.statusAtivacao = statusAtivacao;
	}
	
	
	
}
