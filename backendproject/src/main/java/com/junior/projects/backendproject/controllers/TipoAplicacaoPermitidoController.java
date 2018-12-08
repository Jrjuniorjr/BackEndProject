package com.junior.projects.backendproject.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.junior.projects.backendproject.formatosenvio.TipoAplicacaoFormatoEnvio;
import com.junior.projects.backendproject.services.TipoAplicacaoPermitidoService;
import com.junior.projects.backendproject.model.*;

@RestController
@RequestMapping("/tipoAplicacaoPermitidos")
public class TipoAplicacaoPermitidoController {
	
	@Autowired
	private TipoAplicacaoPermitidoService tipoAplicacaoPermitidoService;
	
	@PostMapping("/adicionarTipoAplicacaoPermitido")
	public ResponseEntity<String> adicionarTipoAplicacaoPermitido(
			@RequestBody TipoAplicacaoFormatoEnvio tipoAplicacaoFormatoEnvio){
	
		return tipoAplicacaoPermitidoService.salvarTipoAplicacaoPermitido(tipoAplicacaoFormatoEnvio);
	
	}
	
	@GetMapping("/listarTodosTiposAplicacoes")
	public ResponseEntity<List<TipoAplicacaoPermitido>> listarTodasAplicacao(){
		
		List<TipoAplicacaoPermitido> tiposAplicacoes = tipoAplicacaoPermitidoService.
		
				listarTodostiposAplicacaoPermitidos();
	
		return ResponseEntity.ok(tiposAplicacoes);
	
	}

}
