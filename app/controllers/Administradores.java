package controllers;

import java.util.List;

import models.Administrador;
import models.Usuario;
import play.cache.Cache;
import play.data.validation.Valid;
import play.mvc.Before;
import play.mvc.Controller;
import play.mvc.With;

@With(Seguranca.class)
public class Administradores extends Controller{


	
	public static void admForm() {
		Administrador adm = (Administrador)Cache.get("adm");
		Cache.clear();
		render(adm);
	}
	public static void salvar( Administrador adm, String senha) {
	
		if (senha.equals("") == false ||  adm.id == null) {
			adm.senha = senha;
			
			if(senha.length() < 6 ) {
			 	validation.addError("adm.senha", "Senha de no minimo 6 caracteres.");
					}
		}
		 
			validation.valid(adm);
			if(senha.equals("") && adm.id != null) {
				validation.removeErrors("adm.senha");
				if (validation.errors().size() == 1){
					validation.clear();
				}
			}
	
		if (validation.hasErrors()){
			validation.keep();
			flash.error("Falha ao salvar administrador");
			Cache.set("adm", adm);
			admForm();
		}else {
		
		adm.save();
		flash.success("Administrador salvo!");
		admForm();
		}
	
		
		
	}
	public static void listar() {
		List<Administrador> administradores = Administrador.findAll();
		render(administradores);
		
		List<Administrador> admnistradores = Administrador.findAll();
		Long idUsuario = Long.parseLong(session.get("usuarioID"));
		Usuario userLogado = Usuario.findById(idUsuario);
		render(administradores, userLogado);
		
	}
	public static void admEditar(long id) {
		Administrador adm = Administrador.findById(id);
		renderTemplate("Administradores/admForm.html", adm); 
	}
	
	public static void admRemover(long id) {
		Administrador adm = Administrador.findById(id);
		adm.delete();
		listar();
		
	}
}
