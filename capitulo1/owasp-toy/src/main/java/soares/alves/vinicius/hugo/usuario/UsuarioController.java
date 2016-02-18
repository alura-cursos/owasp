package soares.alves.vinicius.hugo.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ch.qos.logback.access.pattern.RequestMethodConverter;

@Controller
@Scope("request")
@RequestMapping("/usuarios")
public class UsuarioController {
	
	@Autowired
	private UsuarioDao dao;

	@RequestMapping(method=RequestMethod.POST)
	public String create(UsuarioConfirmacaoSenha obj ,Model m){
		if(obj.isValid()){
			dao.save(obj);
			m.addAttribute("successMessage","Usuário criado com sucesso");
			return "redirect:/login";
		}
		m.addAttribute("errorMessage","Erro ao criar usuário");
		return "usuarios/new";
	}
	
	@RequestMapping(value="/new", method=RequestMethod.GET)
	public String newForm(){
		return "usuarios/new";
	}
	
	@RequestMapping(value="/edit", method=RequestMethod.GET)
	public String editForm(){
		return "usuarios/edit";
	}
	
	@RequestMapping(value="/{id}",method=RequestMethod.POST)
	public String saveEdition(@PathVariable("id") String id,UsuarioI obj ,Model m){
		dao.update(obj);
		m.addAttribute("successMessage","Usuário criado com sucesso");
		return "redirect:/login";
	}
	
}
