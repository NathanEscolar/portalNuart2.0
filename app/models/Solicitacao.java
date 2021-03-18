package models;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


import play.db.jpa.Model;

@Entity
public class Solicitacao extends Model {
	
	
	
	public String DataIn;
	
	public String DataFn;
	
	public String Situacao;
	
	@JoinColumn(name="sala_id")
	@ManyToOne
	public Sala sala;
	
	
	@JoinColumn(name="usuario_id")
	@ManyToOne
	public Usuario usuario;


}
