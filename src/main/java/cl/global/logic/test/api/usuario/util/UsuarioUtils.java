package cl.global.logic.test.api.usuario.util;

import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UsuarioUtils {
	
	private final static Logger logger = Logger.getLogger(UsuarioUtils.class.getName());
	
	private String emailPattern = "^[_a-z0-9-]+(\\.[_a-z0-9-]+)*@" +
		      "[a-z0-9-]+(\\.[a-z0-9-]+)*(\\.[a-z]{2,4})$";
	
	public boolean validaFormatoEmail(String email) {
		
		logger.info("validando formato email: "+email);
		
		Pattern pattern = Pattern.compile(emailPattern);
		
		if (email != null) {
			   Matcher matcher = pattern.matcher(email);
			   if (matcher.matches()) {
				   logger.info(" Email OK");
			     return true;
			   }
			   else {
				   logger.info("email NO OK");
			     return false;
			   } 
		}	
		return false;
	}
	
	

}
