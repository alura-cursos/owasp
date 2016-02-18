package soares.alves.vinicius.hugo.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UsuarioDao {

	private static final String UPDATE = "update usuarios set email='%s', senha='%s' where id = %d";
	private static final String INSERT = "insert into usuarios ( usuario,email,senha ) values ('%s','%s','%s')";
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void save(UsuarioI newObj){
		jdbcTemplate.update(String.format(INSERT,newObj.getUsuario(),newObj.getEmail(),newObj.getSenha()));
		
	}

	public void update(UsuarioI obj) {
		jdbcTemplate.update(String.format(UPDATE,obj.getEmail(),obj.getSenha(),obj.getId()));
	}
}
