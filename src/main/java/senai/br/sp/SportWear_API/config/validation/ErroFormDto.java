package senai.br.sp.SportWear_API.config.validation;

public class ErroFormDto {
	/*Eu quero trabalhar com o campo e a mensagem da exception,
		quais foram os campos e a mensagem
	
	*/
	
	private String campo;
	private String mensagem;
	
	public ErroFormDto(String campo, String mensagem) {
		super();
		this.campo = campo;
		this.mensagem = mensagem;
	}
	
	public String getCampo() {
		return campo;
	}
	public String getMensagem() {
		return mensagem;
	}
	
	
}
