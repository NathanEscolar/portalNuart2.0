package controllers;

import java.util.List;

import models.Emprestimo;
import models.Material;
import models.Usuario;
import play.mvc.Before;
import play.mvc.Controller;
import play.mvc.With;
@With(Seguranca.class)
public class Usuarios extends Controller {

	
	 
	
	
	public static void listarUsuarios() {

		List<Usuario> usuarios = Usuario.findAll();
		renderTemplate("Usuarios/listarUser.html", usuarios);
	}

	
	

}

