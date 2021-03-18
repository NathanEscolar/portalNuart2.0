package models;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import play.data.validation.Required;
import play.db.jpa.Model;

@Entity
public class Emprestimo extends Model {
	
	public  String situacao;
	@Required
	public String dataEmpIn;
	
	
	
	
	@Required
	public String dataEmpFn;	
	
	@Required(message="Selecione um usuário")
	@JoinColumn(name="usuario_id")
	@ManyToOne
	public Usuario usuario;
	

	@ManyToMany
	@JoinTable(name="emprestimos_materiais")
	public List<Material> materiais;
	
	public Emprestimo() {
		
		
		materiais = new ArrayList<Material>();
	}

}
