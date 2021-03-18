package controllers;

import java.util.Date;
import java.util.List;



import models.Emprestimo;
import models.Material;

import models.Usuario;
import play.mvc.Before;
import play.mvc.Controller;
import play.mvc.With;
@With(Seguranca.class)
public class Emprestimos extends Controller {
	
	
	public static void listar() {
		List<Emprestimo> emprestimos = Emprestimo.findAll();
		render(emprestimos);
	}
	
	public static void realizarEmp( List<Long> idMateriais, Long idUsuario, String dataDevolucao, String dataSolicitacao, String s) {
		if(idMateriais == null) {
			flash.error("Selecione o material para realizar o empréstimo!");
			selecionarMat();
		}

			Emprestimo emprestimo = new Emprestimo();
			if (idUsuario == null) {
				flash.error("Selecione um usuario para realizar um emprestimo.");
				selecionarMat();
			}
			Usuario usuario = Usuario.findById(idUsuario);
			
			if (idMateriais != null){
				for (int i = 0; i < idMateriais.size(); i++) {
					Material mat = Material.findById(idMateriais.get(i));
					emprestimo.materiais.add(mat);	
				}
			
			}
			emprestimo.usuario = usuario;
			emprestimo.dataEmpIn = dataSolicitacao;
			emprestimo.dataEmpFn = dataDevolucao;
			emprestimo.situacao = s;
			emprestimo.save();
			listar();
	}
	public static void edicao (Emprestimo emp, List<Long> idMateriais, Long idUsuario, String dataDevolucao, String dataSolicitacao, String s) {
		
		
		if(idMateriais == null) {
			flash.error("Selecione o material para realizar o empréstimo!");
			editar(emp.id);
		}
		if (idUsuario == null) {
			flash.error("Selecione um usuario para realizar um emprestimo.");
			editar(emp.id);
		}
		emp.materiais.clear();
		Usuario usuario = Usuario.findById(idUsuario);
		
		if (idMateriais != null ){
			emp.materiais.clear();
			for (int i = 0; i < idMateriais.size(); i++) {
				Material mat = Material.findById(idMateriais.get(i));
				emp.materiais.add(mat);
			}
		}
	
		emp.usuario = usuario;
		emp.dataEmpIn = dataSolicitacao;
		emp.dataEmpFn = dataDevolucao;
		emp.situacao = s;
		emp.save();
		listar();
		
		
	}
	public static void editar(long id ) {
		Emprestimo emp = Emprestimo.findById(id);
		List<Emprestimo> emprestimos = Emprestimo.findAll();
		
		List<Usuario> usuarios = Usuario.findAll();
		List<Material> materiais = Material.findAll();
		render( emprestimos, emp, usuarios, materiais);
	}
	
	public static void deletar(long id) {
		Emprestimo emp = Emprestimo.findById(id);
		emp.delete();
		listar();
	}
	

	public static void selecionarMat() {
		List<Usuario> usuarios = Usuario.findAll();
		List<Material> materiais = Material.findAll();
		render(materiais, usuarios);	
	}
	public static void detalhesEmp(Long id) {
		 	
		Emprestimo emp = Emprestimo.findById(id);
		
		render(emp);
		 
	
	}
	public static void listaEmpUser(Long id) {
		Usuario user = Usuario.findById(id);
		if(user.id != null) {
		
		render(user);
		}else {
			flash.error("não existem usuarios cadastrados.");
			listar();
		}
	}
	public static void detalhesEmpUser(Long id) {
	 	
		Emprestimo emp = Emprestimo.findById(id);
		
		render(emp);
		 
	
	}
}
