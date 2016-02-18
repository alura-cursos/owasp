package soares.alves.vinicius.hugo.usuario;

public class Usuario implements UsuarioI{

	private Integer id;
	private String usuario;
	private String senha;
	private String email;
	
	
	@Override
	public String getSenha() {
		return senha;
	}
	@Override
	public void setSenha(String senha) {
		this.senha = senha;
	}
	@Override
	public String getUsuario() {
		return usuario;
	}
	@Override
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	@Override
	public String getEmail() {
		return this.email;
	}
	@Override
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public Integer getId() {
		return id;
	}
	@Override
	public void setId(Integer id) {
		this.id = id;
	}
	
	
}
