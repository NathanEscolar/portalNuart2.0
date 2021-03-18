package controllers;

import java.util.List;

import models.Aluno;
import models.Material;
import play.cache.Cache;
import play.data.validation.Valid;
import play.mvc.Before;
import play.mvc.Controller;
import play.mvc.With;
@With(Seguranca.class)
public class Materiais extends Controller {

	
	
	public static void matForm() {
		Material mat = (Material)Cache.get("mat");
		Cache.clear();
		render(mat);
		
	}

	public static void salvar( Material mat) {
		
		
		validation.valid(mat);
		if (validation.hasErrors()) {
			validation.keep();
			
			flash.error("Falha ao cadastrar Material!");
			
			Cache.set("mat", mat);
			matForm();
			
		}
		
		mat.save();
		flash.success("Material cadastrado!");
		matForm();
		

	}

	public static void listar() {
		List<Material> materiais = Material.findAll();
		render(materiais);

	}

	public static void matEditar(long id) {
		Material mat = Material.findById(id);
		renderTemplate("Materiais/matForm.html", mat);
	}

	public static void matRemover(long id) {
		Material mat = Material.findById(id);
		mat.delete();
		listar();
	}

}
