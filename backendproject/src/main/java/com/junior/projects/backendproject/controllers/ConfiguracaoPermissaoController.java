package com.junior.projects.backendproject.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.junior.projects.backendproject.formatosenvio.ConfiguracaoPermissaoFormatoEnvio;
import com.junior.projects.backendproject.services.ConfiguracaoPermissaoService;

@RestController
@RequestMapping("configuracaoPermissao/")
public class ConfiguracaoPermissaoController {

	@Autowired
	private ConfiguracaoPermissaoService configuracaoPermissaoService; 
	
	@PostMapping("/adicionarPermissao")
	public ResponseEntity<String> adicionarPermissao(
			@RequestBody ConfiguracaoPermissaoFormatoEnvio permissaoObject){
		
		return configuracaoPermissaoService.adicionarPermissao(permissaoObject);
	
	}
	
	
}
