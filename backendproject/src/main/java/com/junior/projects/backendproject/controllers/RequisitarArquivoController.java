package com.junior.projects.backendproject.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.junior.projects.backendproject.services.RequisitarArquivoService;


@RestController
@RequestMapping("/requisitarArquivo")
public class RequisitarArquivoController {
	
	@Autowired
	private RequisitarArquivoService requisitarArquivoService;
	
	
}
