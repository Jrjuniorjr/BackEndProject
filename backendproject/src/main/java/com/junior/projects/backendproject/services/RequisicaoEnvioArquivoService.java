package com.junior.projects.backendproject.services;

import java.io.IOException;
import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import com.junior.projects.backendproject.dao.IArquivoDAO;
import com.junior.projects.backendproject.model.*;

public class RequisicaoEnvioArquivoService {
	private Arquivo arquivo;
	
	 @Autowired
	 private TipoArquivoPermitidoService tipoArquivoPermitidoService;
	 
	 @Autowired
	 private OperadorService operadorService;
	
	 @Autowired
	 private IArquivoDAO iArquivoDAO;
	 
	public ResponseEntity adicionarArquivo(MultipartFile multipartFile, String codigoOperador,
			String nomeTipoArquivo, String nomeTipoAplicacao) throws IOException {
		Operador operador = operadorService.consultarOperadorPorCodigo(codigoOperador);
		
		if(operador == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		
		if(!verificarPermissaoEnvio(operador, nomeTipoAplicacao, nomeTipoArquivo)) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		
		else {
			montarArquivo(multipartFile, codigoOperador, nomeTipoArquivo);
			iArquivoDAO.save(arquivo);
			return ResponseEntity.ok("Sucesso!");
		}
		
	}
	public void montarArquivo(MultipartFile multipartFile, String codigoOperador,
			String nomeTipoArquivo) throws IOException{
		arquivo = new Arquivo();
		
		arquivo.setArquivoBytes(multipartFile.getBytes());
		
		arquivo.setDataEnvio(LocalTime.now());
		
		arquivo.setTipoArquivoPermitido(tipoArquivoPermitidoService.
				consultarTipoArquivo(nomeTipoArquivo));
		
		arquivo.setNomeArquivo(multipartFile.getOriginalFilename());
	}
	
	public boolean verificarPermissaoEnvio(Operador operador,
			String nomeTipoAplicacao, String nomeTipoArquivo){
		boolean tipoArquivoPermitidoStatus = false;
		boolean tipoAplicacaoPermitidoStatus = false;
		
		for(TipoArquivoPermitido tipoArquivoPermitido: operador.
				getTiposArquivosPermitidos()) {
			
			if(tipoArquivoPermitido.getNomeTipoArquivoPermitido().equals(nomeTipoArquivo)) {
				tipoArquivoPermitidoStatus = true;
			}
			
		}
		for(TipoAplicacaoPermitido tipoAplicacaoPermitido: operador.getTipoAplicacaoPermitidos()) {
		
			if(tipoAplicacaoPermitido.getNomeTipoAplicacao().equals(nomeTipoAplicacao)) {
				tipoAplicacaoPermitidoStatus = true; 
			}
		}
		
		if(tipoAplicacaoPermitidoStatus && tipoArquivoPermitidoStatus) {
			return true;
		}
		
		else {
			return false;
		}
	}
	
	
}
