package soares.alves.vinicius.hugo.pergunta;

public class Resposta {

	private Integer id;
	private Integer idUsuario;
	private Integer idPergunta;
	private String resposta;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}
	public Integer getIdPergunta() {
		return idPergunta;
	}
	public void setIdPergunta(Integer idPergunta) {
		this.idPergunta = idPergunta;
	}
	public String getResposta() {
		return resposta;
	}
	public void setResposta(String resposta) {
		this.resposta = resposta;
	}
	
	
}
