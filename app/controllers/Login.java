package controllers;

import models.Administrador;
import models.Aluno;
import models.Servidor;
import models.Usuario;
import play.libs.Crypto;
import play.mvc.Controller;
import play.mvc.With;

public class Login extends Controller {

	public static void login() {
		
		
		
		render();
	}

	
	
	
	public static void autenticar(String userMatric, String senha) {

		Usuario usuario = Usuario.find("userMatric = ? and senha = ? ", userMatric, Crypto.passwordHash(senha)).first();

		if (usuario != null ) {
			if (usuario instanceof Administrador) {
				
				
				
			
			session.put("usuarioID", usuario.id);

			session.put("nomeID", usuario.nome);
			session.put("matricID", usuario.userMatric);
			Application.index();
		
			}
			
		}else {
			flash.error("Usuario ou senha incorretos!");
			login();
			}
	}

	public static void logout() {
		session.clear();
		login();
	}

}
