package controllers;

import java.util.List;

import models.Servidor;
import models.Usuario;
import play.cache.Cache;
import play.data.validation.Valid;
import play.mvc.Before;
import play.mvc.Controller;
import play.mvc.With;
@With(Seguranca.class)
public class Servidores extends Controller {
	
	
	public static void servForm(){
		Servidor serv = (Servidor)Cache.get("serv");
		Cache.clear();
		render(serv);
	}
	
	public static void salvar(@Valid Servidor serv) {
		if (validation.hasErrors()) {
			validation.keep();
			
			flash.error("Falha ao cadastrar servidor!");
			Cache.set("serv", serv);
			servForm();
		}
		
		serv.save();
		flash.success("Servidor salvo!");
		servForm();
		
	}
	
	public static void listar() {
		List<Servidor> servidores = Servidor.findAll();
		render(servidores);
		
	}	
	public static void servEditar(long id) {
		Servidor serv = Servidor.findById(id);
		renderTemplate("Servidores/servForm.html", serv);
	}
	public static void servRemover(long id) {
		Servidor serv = Servidor.findById(id);
		serv.delete();
		flash.success("Servidor remvido!");
		session.clear();
		listar();
		
	}
}
