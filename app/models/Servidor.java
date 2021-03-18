package models;

import javax.persistence.Entity;

import play.data.validation.Required;
import play.db.jpa.Model;

@Entity
public class Servidor extends Usuario {
	
	public String setor;
	
	
	@Required
	public String cargo;
 

}
