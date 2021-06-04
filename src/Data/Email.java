package Data;

import java.util.regex.Pattern;

public class Email {

	String email;

	public Email(String email) {
		
		if(!emailIsValid(email)) {
			
			this.email = null;
			
		}else {
			
			this.email = email;
		
		}
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public static boolean emailIsValid(String email)
    {
		
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
                            "[a-zA-Z0-9_+&*-]+)*@" +
                            "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                            "A-Z]{2,7}$";
                              
        Pattern pat = Pattern.compile(emailRegex);
        if (email == null)
            return false;
        return pat.matcher(email).matches();
        
    }
	
}
