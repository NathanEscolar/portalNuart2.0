package models;

import javax.persistence.Entity;
import javax.persistence.Transient;

import play.data.validation.Email;
import play.data.validation.Equals;
import play.data.validation.Required;
import play.data.validation.Unique;
import play.libs.Crypto;

@Entity
public class Administrador extends Usuario {
	
	@Required
	@Email(message = "Digite um email valido")
	@Unique
	public String email;
		
	@Required
	@Equals("confirmacaoSenha")
	public String senha; 
	
	@Transient
	public String confirmacaoSenha;

	
	
	public void setSenha(String s){
		   //123456
		//4QrcOUm6Wau+VuBX8g+IPg==
		senha = Crypto.passwordHash(s);
	}
	public void setConfirmacaoSenha (String s) {
		if(s == null) 
			confirmacaoSenha = s;
			
		else
		confirmacaoSenha = Crypto.passwordHash(s);
	}

	

	
		
}
