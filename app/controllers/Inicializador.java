package controllers;

import models.Administrador;
import models.Sala;
import play.jobs.Job;
import play.jobs.OnApplicationStart;
import play.libs.Crypto;
import play.test.Fixtures;

@OnApplicationStart
public class Inicializador extends Job {
	
	public void doJob() {
		if (Administrador.count() == 0){
			
			Administrador adm = new Administrador();
			
			adm.nome = "Nathan Vinicius";
			adm.email = "Nathan@gmail.com";
			adm.senha = "123456";
		    adm.userMatric ="20152021";
		    adm.save();
		}
		if (Sala.count() == 0){
			
			Sala nuart = new Sala();
			
			nuart.nSala = 72;
			nuart.bloco = "Bloco 1";
			nuart.save();
		}
			
			
		
	
	}
	
}
