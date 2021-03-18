package models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import play.db.jpa.Model;
@Entity
public class Sala extends Model{
	 public int nSala;
	 public String bloco;
	 
	 
	
	 @OneToMany(mappedBy="sala")
		public List<Solicitacao> solicitacoes;


}
