package com.junior.projects.backendproject.controllers;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.junior.projects.backendproject.formatosenvio.ConfiguracaoPermissaoFormatoEnvio;
import com.junior.projects.backendproject.services.RequisicaoEnvioArquivoService;


@RestController
@RequestMapping("/requisitarEnvioArquivo")

public class RequisicaoEnvioArquivoController {
	
	@Autowired
	private RequisicaoEnvioArquivoService requisicaoEnvioArquivoService;
	
	@PostMapping("/salvarArquivo")
	public ResponseEntity<String> salvarArquivo(@RequestParam("arquivo") MultipartFile multipartFile,
			@RequestParam("codigoOperador") String codigoOperador,
			@RequestParam("nomeTipoArquivo") String nomeTipoArquivo,
			@RequestParam("nomeTipoAplicacao") String nomeTipoAplicacao) throws IOException{
	
		return requisicaoEnvioArquivoService.
				adicionarArquivo(multipartFile, codigoOperador, nomeTipoArquivo, nomeTipoAplicacao);
	}
	
	@PostMapping("/processamentoArquivo")
	public HttpEntity processamentoArquivo(@RequestBody String nomeArquivo) throws IOException {
		return requisicaoEnvioArquivoService.processamentoArquivo(nomeArquivo);
	}
	
}
