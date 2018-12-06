package com.junior.projects.backendproject.model;

import java.util.List;

import javax.persistence.*;

import lombok.*;

@Entity()
@Table(name = "Operador")
public class Operador {
	@Id 
	@Column (name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column (name = "codigo")
	private String codigo;
	
    @ManyToMany
    @JoinTable(name="usuarioTipoArquivo",
            joinColumns = @JoinColumn(name="idUsuario", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "idTipoArquivoPermitido", referencedColumnName = "id")
    )
	private List<TipoArquivoPermitido> tiposArquivosPermitidos;
    
    @ManyToMany
    @JoinTable(name="usuarioTipoAplicacao",
            joinColumns = @JoinColumn(name="idUsuario", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "idTipoAplicacaoPermitido", referencedColumnName = "id")
    )
    private List<TipoAplicacaoPermitido> tipoAplicacaoPermitidos;
    
    @Enumerated(EnumType.STRING)
	@Column(name="tipo", columnDefinition="enum('Administrador', 'Operador')")
    private TipoFuncionario tipoFuncionario;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public List<TipoArquivoPermitido> getTiposArquivosPermitidos() {
		return tiposArquivosPermitidos;
	}

	public void setTiposArquivosPermitidos(List<TipoArquivoPermitido> tiposArquivosPermitidos) {
		this.tiposArquivosPermitidos = tiposArquivosPermitidos;
	}

	public List<TipoAplicacaoPermitido> getTipoAplicacaoPermitidos() {
		return tipoAplicacaoPermitidos;
	}

	public void setTipoAplicacaoPermitidos(List<TipoAplicacaoPermitido> tipoAplicacaoPermitidos) {
		this.tipoAplicacaoPermitidos = tipoAplicacaoPermitidos;
	}

	public TipoFuncionario getTipoFuncionario() {
		return tipoFuncionario;
	}

	public void setTipoFuncionario(TipoFuncionario tipoFuncionario) {
		this.tipoFuncionario = tipoFuncionario;
	}
    
    
}
