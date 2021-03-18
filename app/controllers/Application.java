package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

import models.*;
@With(Seguranca.class)
public class Application extends Controller {

	
	public static void index() {
        
		String nomeID = session.get("nomeID");
		String matricID = session.get("matricID");
    	
    	render(nomeID, matricID);
    }

}