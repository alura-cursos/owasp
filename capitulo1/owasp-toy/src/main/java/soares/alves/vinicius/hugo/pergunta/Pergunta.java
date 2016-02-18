package soares.alves.vinicius.hugo.pergunta;

public class Pergunta implements PerguntaI {
	
	private Integer id;
	private String pergunta;
	private Integer idUsuario;
	
	@Override
	public Integer getId() {
		return id;
	}
	
	@Override
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Override
	public String getPergunta() {
		return pergunta;
	}
	
	@Override
	public void setPergunta(String pergunta) {
		this.pergunta = pergunta;
	}
	
}
