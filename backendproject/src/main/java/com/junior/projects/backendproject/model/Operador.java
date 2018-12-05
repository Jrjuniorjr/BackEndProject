package com.junior.projects.backendproject.model;

import java.util.List;

import javax.persistence.*;

import lombok.*;

@Entity()
@Table(name = "Operador")
@Getter @Setter
public class Operador {
	@Id 
	@Column (name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column (name = "codigo")
	private String codigo;
	
    @ManyToMany
    @JoinTable(name="usuario_tipoCaptura",
            joinColumns = @JoinColumn(name="usuario_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "tipo_captura_id", referencedColumnName = "id")
    )
	private List<TipoArquivoPermitido> tiposArquivosPermitidos;
}
