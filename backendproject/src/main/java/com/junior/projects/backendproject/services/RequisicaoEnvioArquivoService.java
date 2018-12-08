package com.junior.projects.backendproject.services;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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

	public ResponseEntity adicionarArquivo(MultipartFile multipartFile, String codigoOperador, String nomeTipoArquivo,
			String nomeTipoAplicacao) throws IOException {
		Operador operador = operadorService.consultarOperadorPorCodigo(codigoOperador);

		if (operador == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}

		if (!verificarPermissaoEnvio(operador, nomeTipoAplicacao, nomeTipoArquivo)) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}

		else {
			montarArquivo(multipartFile, codigoOperador, nomeTipoArquivo);
			iArquivoDAO.save(arquivo);
			return ResponseEntity.ok("Sucesso!");
		}

	}

	public HttpEntity processamentoArquivo(String nomeArquivo) throws IOException{
		arquivo = iArquivoDAO.findByNomeArquivo(nomeArquivo);
		byte planilhaExcel[] = criarPlanilha();
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders
				.setContentType(new MediaType("application", "vnd.openxmlformats-officedocument.spreadsheetml.sheet"));
		httpHeaders.set(HttpHeaders.CONTENT_DISPOSITION,
				"attachment;filename=" + arquivo.getNomeArquivo() + "PlanilhaExcel");
		httpHeaders.setContentLength(planilhaExcel.length);
		return new HttpEntity<>(planilhaExcel, httpHeaders);

	}

	private byte[] criarPlanilha() throws IOException {
		byte[] planilha;
		int contador = 0;
		ContagemPalavras contagemPalavras = contadorPalavras();
		HSSFWorkbook hSSFWorkbook = new HSSFWorkbook();
		HSSFSheet hSSFSheet = hSSFWorkbook.createSheet("ResultadoSheet");
		FileOutputStream outputStream;
		outputStream = new FileOutputStream(new File("Resultado"));
		for (String palavra : contagemPalavras.getPalavras()) {
			HSSFRow row = hSSFSheet.createRow(contador);
			row.createCell(0).setCellValue(palavra);
			row.createCell(1).setCellValue(contagemPalavras.getQtdPalavras().get(contador));
			contador++;
		}

		planilha = Files.readAllBytes(Paths.get("Resultado"));
		hSSFWorkbook.write(outputStream);
		outputStream.close();
		return planilha;

	}

	private ContagemPalavras contadorPalavras() {
		ContagemPalavras contagemPalavras;
		if (arquivo.getTipoArquivoPermitido().getNomeTipoArquivoPermitido().equals("jpg")
				|| arquivo.getTipoArquivoPermitido().getNomeTipoArquivoPermitido().equals("tif")) {
			contagemPalavras = mockarImagens(arquivo);
			return contagemPalavras;
		} else {
			return null;
		}
	}

	private ContagemPalavras mockarImagens(Arquivo arquivo1) {
		ContagemPalavras contagemPalavras = new ContagemPalavras();
		List<String> palavras = new ArrayList<>();
		palavras.add("Oi");
		palavras.add("Tudo bom?");
		palavras.add("OK");
		List<Integer> qtdPalavras = new ArrayList<>();
		qtdPalavras.add(1);
		qtdPalavras.add(3);
		qtdPalavras.add(5);
		contagemPalavras.setPalavras(palavras);
		contagemPalavras.setQtdPalavras(qtdPalavras);
		return contagemPalavras;
	}

	private void montarArquivo(MultipartFile multipartFile, String codigoOperador, String nomeTipoArquivo)
			throws IOException {
		arquivo = new Arquivo();

		arquivo.setArquivoBytes(multipartFile.getBytes());

		arquivo.setDataEnvio(LocalTime.now());

		arquivo.setTipoArquivoPermitido(tipoArquivoPermitidoService.consultarTipoArquivo(nomeTipoArquivo));

		arquivo.setNomeArquivo(multipartFile.getOriginalFilename());
	}

	private boolean verificarPermissaoEnvio(Operador operador, String nomeTipoAplicacao, String nomeTipoArquivo) {
		boolean tipoArquivoPermitidoStatus = false;
		boolean tipoAplicacaoPermitidoStatus = false;

		for (TipoArquivoPermitido tipoArquivoPermitido : operador.getTiposArquivosPermitidos()) {

			if (tipoArquivoPermitido.getNomeTipoArquivoPermitido().equals(nomeTipoArquivo)) {
				tipoArquivoPermitidoStatus = true;
			}

		}
		for (TipoAplicacaoPermitido tipoAplicacaoPermitido : operador.getTipoAplicacaoPermitidos()) {

			if (tipoAplicacaoPermitido.getNomeTipoAplicacao().equals(nomeTipoAplicacao)) {
				tipoAplicacaoPermitidoStatus = true;
			}
		}

		if (tipoAplicacaoPermitidoStatus && tipoArquivoPermitidoStatus) {
			return true;
		}

		else {
			return false;
		}
	}

}
