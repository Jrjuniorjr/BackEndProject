# BackEndProject

Projeto feito em Spring Boot, com o objetivo de:
- Cadastrar operadores
- Cadastrar tipos de arquivos permitidos
- Cadatrar tipos de aplicações permitidos
- Fornecer permissao de envio e manipulacao ao operador especifico

COMO EXECUTAR : Ter uma IDE para realizar a compilação e usar o POSTMAN para acessar as URLs dos controllers.

Tipos de parametros enviados:

url("/requisitarEnvioArquivo")
RequisicaoEnvioArquivoController
  1 - salvar arquivo em banco
    1.1 - path("/salvarArquivo")
    1.2 - Tipos de parametros enviados: @RequestParam("arquivo") MultipartFile multipartFile,
			@RequestParam("codigoOperador") String codigoOperador,
			@RequestParam("nomeTipoArquivo") String nomeTipoArquivo,
			@RequestParam("nomeTipoAplicacao") String nomeTipoAplicacao
  2 - processar arquivo
    2.1 - path("/processamentoArquivo")
    2.2 - Tipos de parametros enviados: @RequestParam String nomeArquivo,
			@RequestParam("codigoOperador") String codigoOperador,
      @RequestParam("nomeTipoAplicacao") String nomeTipoAplicacao
      
      
url("configuracaoPermissao/")
ConfiguracaoPermissaoController
  1 - adicionar permissao
    1.1 - path("/adicionarPermissao")
    1.2 - Tipos de parametros enviados: @RequestBody ConfiguracaoPermissaoFormatoEnvio permissaoObject
    

url("/operador")
OperadorController
  1 - salvar operador em banco
    1.1 - path("/adicionarOperador")
    1.2 - Tipos de parametros enviados: @RequestBody OperadorFormatoEnvio operadorFormatoEnvio
  2 - consultar operador
    2.1 - path("/consultarOperador")
    2.2 - Tipos de parametros enviados: @RequestBody String codigo
    
    
    
url("/tipoAplicacaoPermitidos")
TipoAplicacaoPermitidoController
  1 - salvar tipo aplicacao em banco
    1.1 - path("/adicionarTipoAplicacaoPermitido")
    1.2 - Tipos de parametros enviados: @RequestBody TipoAplicacaoFormatoEnvio tipoAplicacaoFormatoEnvio
    2 - listas todas as aplicacoes
    2.1 - path("/listarTodasTiposAplicacoes")
    2.2 - Tipos de parametros enviados: 
    
    
url("/tipoArquivosPermitidos")
TipoAplicacaoPermitidoController
  1 - salvar tipo arquivo em banco
    1.1 - path("/adicionarTipoArquivoPermitido")
    1.2 - Tipos de parametros enviados: @RequestBody TipoArquivoFormatoEnvio tipoArquivoFormatoEnvio
  2 - listar todos os arquivos
    2.1 - path("/listarTodosArquivos")
    2.2 - Tipos de parametros enviados: 
    
ConfiguracaoPermissaoFormatoEnvio {
	string codigoOperador;
	String codigoAdministrador;
	List<TipoAplicacaoPermitido> tipoAplicacaoPermitidos;
  List<TipoArquivoPermitido> tiposArquivosPermitidos;
	}
  
 OperadorFormatoEnvio {
	String codigoAdministrador;
	Operador operador;
	}
  
 TipoAplicacaoFormatoEnvio {
	String codigoAdministrador;
	TipoAplicacaoPermitido tipoAplicacaoPermitido;
	}
  
TipoArquivoFormatoEnvio {
  String codigoAdministrador;
	TipoArquivoPermitido tipoArquivoPermitido;
  }
  
  
