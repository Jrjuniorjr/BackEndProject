package com.junior.projects.backendproject.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.junior.projects.backendproject.formatosenvio.ConfiguracaoPermissaoFormatoEnvio;


@RestController
@RequestMapping("/requisitarEnvioArquivo")
public class RequisicaoEnvioArquivoController {
	
	@PostMapping("/salvarArquivo")
	public ResponseEntity<String> salvarArquivo(@RequestParam("arquivo") MultipartFile multipartFile,
			@RequestParam("codigoOperador") String codigoOperador,
			@RequestParam("nomeTipoArquivo") String nomeTipoArquivo,
			@RequestParam("nomeTipoAplicacao") String nomeTipoAplicacao){
	
		return salvarArquivo(multipartFile, codigoOperador, nomeTipoArquivo, nomeTipoAplicacao);
	}
	
}
