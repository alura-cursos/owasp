package soares.alves.vinicius.hugo.pergunta;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class RespostaDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<Resposta> procurarPorRespostas(String id) {
		
		return jdbcTemplate.query("select id,resposta,usuario_id,pergunta_id from respostas where pergunta_id = "+ id, new BeanPropertyRowMapper<Resposta>(Resposta.class));
	}

}
