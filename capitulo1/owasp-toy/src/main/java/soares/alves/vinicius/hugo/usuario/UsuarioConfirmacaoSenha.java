package soares.alves.vinicius.hugo.usuario;

public class UsuarioConfirmacaoSenha implements UsuarioI{
	private UsuarioI inner = new Usuario();
	
	private String confirmacaoSenha;
	
	public Boolean isValid(){
		if(getSenha()==null || confirmacaoSenha == null){
			return false;
		}
		return getSenha().equals(confirmacaoSenha);
	}

	public void setConfirmacaoSenha(String confirmacaoSenha) {
		this.confirmacaoSenha = confirmacaoSenha;
	}

	public void setId(Integer id) {
		inner.setId(id);
	}

	public Integer getId() {
		return inner.getId();
	}

	public void setEmail(String email) {
		inner.setEmail(email);
	}

	public String getEmail() {
		return inner.getEmail();
	}

	public void setUsuario(String usuario) {
		inner.setUsuario(usuario);
	}

	public String getUsuario() {
		return inner.getUsuario();
	}

	public void setSenha(String senha) {
		inner.setSenha(senha);
	}

	public String getSenha() {
		return inner.getSenha();
	}

}
