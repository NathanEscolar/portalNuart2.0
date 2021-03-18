 package models;

import java.util.List;

import javax.persistence.Entity;

import play.data.validation.Required;

@Entity
public class Aluno extends Usuario {
	
	
	
	@Required(message="O curso é obrigatório")
	public String curso;
	
	@Required(message="A turma é obrigatória")
	public String turma;
	
	@Required(message="O turno é obrigatório")
	public String turno;

}
