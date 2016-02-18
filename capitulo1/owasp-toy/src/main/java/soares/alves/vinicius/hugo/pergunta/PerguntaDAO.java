package soares.alves.vinicius.hugo.pergunta;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseStatus;

@Repository
public class PerguntaDAO {

	private static final BeanPropertyRowMapper<Pergunta> DEFAULT_ROW_MAPPER = new BeanPropertyRowMapper<Pergunta>(Pergunta.class);
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired 
	private RespostaDAO respostaDAO;

	public void criarPergunta(PerguntaI obj, String idUsuario) {
		jdbcTemplate.update(
				"insert into perguntas (pergunta,usuario_id) values ('" + obj.getPergunta() + "'," + idUsuario + ")");
	}

	public List<Pergunta> getPerguntas() {	
		return jdbcTemplate.query(
				"select id,pergunta,usuario_id from perguntas order by id desc fetch first 20 rows only", 
				DEFAULT_ROW_MAPPER
			);	
	}

	public PerguntaI get(String id) {
		List<Pergunta> resultadoConsulta = jdbcTemplate.query(
				"select id,pergunta,usuario_id from perguntas where id = " + id, 
				DEFAULT_ROW_MAPPER
			);		
		
		return new PerguntaAggregador(resultadoConsulta.get(0),respostaDAO.procurarPorRespostas(id));
		
	}

}
