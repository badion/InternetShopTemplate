package ua.internetshop.exceptions;

public class UserAlreadyInUseException extends Exception {

	private static final long serialVersionUID = 1L;

	public UserAlreadyInUseException(String username) {
		super("The username '" + username + "' is already in use.");
	}

}
