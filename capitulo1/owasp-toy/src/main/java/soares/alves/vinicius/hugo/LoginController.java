package soares.alves.vinicius.hugo;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import soares.alves.vinicius.hugo.usuario.Usuario;
import soares.alves.vinicius.hugo.usuario.UsuarioI;

@Controller
@Scope("request")
@RequestMapping("/login")
public class LoginController{
	
	
	
	

	@Autowired
	public JdbcTemplate jdbcTemplate;
	private String errorMessage;
	private String successMessage;
	
	

	@RequestMapping(method=RequestMethod.GET)
	public String inicio(Model m){		
		zerar();
		return "login/new";
	}
	
	
	private void zerar() {
		errorMessage = successMessage = null;
	}


	@RequestMapping(method=RequestMethod.POST)
	
	public String realizarLogin(Usuario usuario, Model m,HttpServletRequest request){

		
		Integer resultado = jdbcTemplate.queryForObject(String.format(
				"select count(1) from usuarios where usuario='%s' and senha = '%s' ", 
				usuario.getUsuario(),usuario.getSenha()
		), Integer.class);
		
		if(resultado == 0){

			Integer existeUsuario = jdbcTemplate.queryForObject(String.format(
					"select count(1) from usuarios where usuario='%s'", 
					usuario.getUsuario()
			), Integer.class);
			if(existeUsuario==0){
				errorMessage = "Usuario não encontrado";
			}else{
				errorMessage = "Senha errada";
			}
		}
		if(resultado == 1){
			successMessage = "Logado com sucesso";
			m.addAttribute("successMessage",successMessage);
			salvarIdUsuario(usuario,request);
			return "redirect:/perguntas/";
		}
		m.addAttribute("errorMessage",errorMessage);
		
		return "login/new";
		
		
	}
	
	private void salvarIdUsuario(UsuarioI usuario, HttpServletRequest request) {
		request.getSession().setAttribute("idUsuario", jdbcTemplate.queryForObject("select id from usuarios where usuario = ?", Integer.class, usuario.getUsuario()));
	}


	@ModelAttribute("errorMessage")
	public String getErrorMessage(){
		
		return errorMessage;
	}
}
