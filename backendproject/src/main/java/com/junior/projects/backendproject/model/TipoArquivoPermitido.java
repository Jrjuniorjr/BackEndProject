package com.junior.projects.backendproject.model;

import javax.persistence.*;

import lombok.*;

@Entity()
@Table(name = "tipoArquivoPermitido")
public class TipoArquivoPermitido {

	@Id 
	@Column (name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter @Setter
	private int id;
	
	@Getter @Setter
	@Column (name = "tipoArquivoPermitido")
	private String tipoArquivoPermitido;
	
	@Getter @Setter
	@Enumerated(EnumType.STRING)
	@Column(name="tipo", columnDefinition="enum('Ativo', 'Inativo')")
	private StatusAtivacao statusAtivacao;
}
