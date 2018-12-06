package com.junior.projects.backendproject.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.junior.projects.backendproject.formatosenvio.TipoArquivoFormatoEnvio;
import com.junior.projects.backendproject.model.TipoArquivoPermitido;
import com.junior.projects.backendproject.services.TipoArquivoPermitidoService;


public class TipoArquivoPermitidoController {
	
	@Autowired
	private TipoArquivoPermitidoService tipoArquivoPermitidoService;
	
	@PostMapping("/adicionarTipoArquivoPermitido")
	public ResponseEntity<String> adicionarTipoAplicacaoPermitido(@RequestBody TipoArquivoFormatoEnvio tipoArquivoFormatoEnvio){
		return tipoArquivoPermitidoService.salvarTipoArquivoPermitido(tipoArquivoFormatoEnvio);
	}
	
	@GetMapping("/listarTodosTiposArquivos")
	public ResponseEntity<List<TipoArquivoPermitido>> listarTodosArquivos(){
		List<TipoArquivoPermitido> tiposArquivos = tipoArquivoPermitidoService.listarTodostiposArquivosPermitidos();
		return ResponseEntity.ok(tiposArquivos);
	}
}
