package soares.alves.vinicius.hugo.pergunta;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Component
@Scope("request")
@RequestMapping("/perguntas")
public class PerguntasController {

	@Autowired
	public JdbcTemplate jdbcTemplate;
	
	@Autowired
	private PerguntaDAO perguntaDAO;
	
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String index( Model m){
		m.addAttribute("perguntas", perguntaDAO.getPerguntas());		
		return "perguntas/index";		
	}
	
	@RequestMapping(value="/new",method=RequestMethod.GET)
	public String newObj(){
		return "perguntas/new";
	}
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public String view(@PathVariable("id") String id, Model m){
		m.addAttribute("pergunta", perguntaDAO.get(id));
		
		return "perguntas/view";
		
		
	}
	
	
	@RequestMapping(value="/", method=RequestMethod.POST)
	public String create(PerguntaI obj,Model m, HttpSession session){
		
		String idUsuario = session.getAttribute("idUsuario").toString();
		perguntaDAO.criarPergunta(obj, idUsuario);
		
		return "redirect:/perguntas/";
		
	}


	
	
	
}
