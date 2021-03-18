package controllers;

import java.util.List;

import models.Aluno;
import models.Usuario;
import play.cache.Cache;
import play.data.validation.Valid;
import play.mvc.Before;
import play.mvc.Controller;
import play.mvc.With;
@With(Seguranca.class)
public class Alunos extends Controller{

	 
	public static void alForm() {
		
		Aluno al = (Aluno)Cache.get("al");
		Cache.clear();
		render(al);
	}
	public static void salvar(@Valid Aluno al) {
		
		
		
		if (validation.hasErrors()) {
			validation.keep();
			
			flash.error("Falha ao cadastrar aluno!");
			
			Cache.set("al", al);
			
			alForm();
		}
		
		al.save();
		flash.success("Aluno cadastrado!");
		alForm();
		
	}
	public static void listar() {
		List<Aluno> alunos = Aluno.findAll();
		render(alunos);
		
			
	}
	public static void alEditar(long id) {
		Aluno al = Aluno.findById(id);
		renderTemplate("Alunos/alForm.html", al); 
	}
	
	public static void alRemover(long id) {
		Aluno al = Aluno.findById(id);
		al.delete();
		flash.success("Aluno removido!");
		listar();
		
	}
}
