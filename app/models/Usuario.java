package models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import play.data.validation.Required;
import play.data.validation.Unique;
import play.db.jpa.Model;

@Entity
public class Usuario extends Model {
	
	@Required(message="O nome é obrigatório!")
	@Unique(message="Esse usuario ja esta cadastrado")
	public String nome;
	
	@Required(message="A matricula é obrigatória!")
	@Unique(message="Esse usuario ja esta cadastrado")
	public String userMatric;
	
	
	@OneToMany(mappedBy="usuario")
	public List<Emprestimo> emprestimos;
	
	@OneToMany(mappedBy="usuario")
	public List<Solicitacao> solicitacoes;

}
