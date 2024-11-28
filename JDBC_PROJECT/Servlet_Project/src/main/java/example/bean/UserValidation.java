package example.bean;

public class UserValidation {

	public static boolean isValid(User userObject) {
		boolean result=false;
		String currentUserId=userObject.getUsername();
		String currentpassword=userObject.getPassword();
		if(
				currentUserId.equals("admin")
				&&
				currentpassword.equals("phoniex123")
						)
				result=true;
				return result;
	}

}
