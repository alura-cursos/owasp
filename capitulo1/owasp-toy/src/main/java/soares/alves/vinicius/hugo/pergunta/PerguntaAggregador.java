package soares.alves.vinicius.hugo.pergunta;

import java.util.Collection;

public class PerguntaAggregador implements PerguntaI{

	private Pergunta inner;
	private Collection<Resposta> respostas;


	public PerguntaAggregador(Pergunta inner, Collection<Resposta> respostas) {
		super();
		this.inner = inner;
		this.respostas = respostas;
	}	

	public Integer getId() {
		return inner.getId();
	}

	public void setId(Integer id) {
		inner.setId(id);
	}

	public String getPergunta() {
		return inner.getPergunta();
	}

	public void setPergunta(String pergunta) {
		inner.setPergunta(pergunta);
	}

	public int hashCode() {
		return inner.hashCode();
	}

	public boolean equals(Object obj) {
		return inner.equals(obj);
	}

	public String toString() {
		return inner.toString();
	}

	public Collection<Resposta> getRespostas() {
		return respostas;
	}
	
	
}
