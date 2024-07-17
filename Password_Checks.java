package bank_management;

public class Password_Checks {
	boolean check_Strong_Password(String password) {
		int i, j;
		if(password.length() < 8)
			return false;
		else {
			for(i = 0; i < 4; i++) {
				for(j = 0; j < password.length(); j++) {
					if(i == 0) {
						if(password.charAt(j) >= 48 && password.charAt(j) <= 57) {
							break;
						}
					}
					
					if(i == 1) {	
						if(password.charAt(j) >= 65 && password.charAt(j) <= 90)  {
							break;
						}
					}
					
					if(i == 2) {	
						if(password.charAt(j) >= 97 && password.charAt(j) <= 122)  {
							break;
						}
					}
					
					if(i == 3) {
						if((password.charAt(j) >= 33 && password.charAt(j) <= 47) || (password.charAt(j) >= 58 && password.charAt(j) <= 64) || (password.charAt(j) >= 91 && password.charAt(j) <= 96) || (password.charAt(j) >= 123 && password.charAt(j) <= 126)) {
							break;
						}
					}
				}
				if(j >= password.length()) 
					break;
			}
			
			if (i < 4)
				return false;
			else
				return true;
		}
	}
	
	boolean check_4digit(int pin) {
		int count = 0;
		for(int i = pin; i > 0; i = i / 10) {
			count++;
		}
		if(count == 4)
			return true;
		else
			return false;
	}
	
	boolean check_6digit(int pin) {
		int count = 0;
		for(int i = pin; i > 0; i = i / 10) {
			count++;
		}
		if(count == 6)
			return true;
		else
			return false;
	}
	
	boolean check_3digit(int pin) {
		int count = 0;
		for(int i = pin; i > 0; i = i / 10) {
			count++;
		}
		if(count == 3)
			return true;
		else
			return false;
	}
	
}
