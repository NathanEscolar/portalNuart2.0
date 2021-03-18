package controllers;

import java.util.Date;
import java.util.List;




import models.Sala;
import models.Solicitacao;
import models.Usuario;
import play.mvc.Before;
import play.mvc.Controller;
import play.mvc.With;
@With(Seguranca.class)
public class Solicitacoes extends Controller {
	
	
	public static void listar() {
		List<Solicitacao> solicitacoes = Solicitacao.findAll();
		render(solicitacoes);	
	}
	
	public static void salvar( Long idUsuario, Long idSala, String dataSolicitacao, String dataDevolucao, String situ) {
	
	Solicitacao sol = new Solicitacao();
	if(idUsuario == null) {
		flash.error("Selecione um usuario para realizar um emprestimo.");
		agendar();
	}
	Usuario user = Usuario.findById(idUsuario);
	Sala sal = Sala.findById(idSala);
	
	sol.usuario = user;
	sol.sala = sal;
	sol.DataIn = dataSolicitacao;
	sol.DataFn = dataDevolucao;
	sol.Situacao = situ;
	sol.save();
	listar();
	}
	public static void edicao(Solicitacao sol,  Long idUsuario, Long idSala, String dataSolicitacao, String dataDevolucao, String situ ) {
	
		Usuario user = Usuario.findById(idUsuario);
		Sala sal = Sala.findById(idSala);
		
		sol.usuario = user;
		sol.sala = sal;
		sol.DataIn = dataSolicitacao;
		sol.DataFn = dataDevolucao;
		sol.Situacao = situ;
		sol.save();
		listar();
	}
	public static void editar(long id ) {
		Solicitacao solicitacao = Solicitacao.findById(id);
		List<Usuario> usuarios = Usuario.findAll();
		List<Sala> salas = Sala.findAll();
		renderTemplate("Solicitacoes/editar.html", usuarios, solicitacao, salas);
	}
	
	public static void deletar(long id) {
		Solicitacao sol = Solicitacao.findById(id);
		sol.delete();
		listar();
	}
	

	public static void agendar() {
		List<Sala> salas = Sala.findAll();
		List<Usuario> usuarios = Usuario.findAll();
		render(salas, usuarios);	
	}
	
	public static void listaAgendamentoUser(long id) {
		
		Usuario user = Usuario.findById(id);
		render(user);
}
}
