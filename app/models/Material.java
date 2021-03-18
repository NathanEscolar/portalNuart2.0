package models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;

import play.data.validation.Required;
import play.data.validation.Unique;
import play.db.jpa.Model;

@Entity
public class Material extends Model {
	
	@Required
	@Unique(message="material ja esta cadastrado")
	public String nTombo;
	
	@Required
	public String nome;
	@Required
	public String cor;
	@Required
	public String detalhes;
	
	
	
	@ManyToMany(mappedBy="materiais")
	public List<Emprestimo> emprestimos;
	
	
}
