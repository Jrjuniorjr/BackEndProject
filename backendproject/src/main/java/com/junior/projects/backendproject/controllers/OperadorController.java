package com.junior.projects.backendproject.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.junior.projects.backendproject.formatosenvio.OperadorFormatoEnvio;
import com.junior.projects.backendproject.model.Operador;
import com.junior.projects.backendproject.services.OperadorService;

@RestController
@RequestMapping("/operador")
public class OperadorController {
	
	@Autowired
	private OperadorService operadorService;
	
	@PostMapping("/adicionarOperador")
	public ResponseEntity<String> adicionarOperador(
			@RequestBody OperadorFormatoEnvio operadorFormatoEnvio){
		
		return operadorService.salvarOperador(operadorFormatoEnvio);
	
	}
	
	@PostMapping("/consultarOperador")
	public ResponseEntity<Operador> consultarOperador(@RequestBody String codigo){
		Operador operador = operadorService.consultarOperadorPorCodigo(codigo);
		return ResponseEntity.ok(operador);
	}
}
