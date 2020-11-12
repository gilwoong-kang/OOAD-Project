package util;

public class UserDuplicationException extends RuntimeException{

	private static final long serialVersionUID = 2784391401931041830L;

	public UserDuplicationException(String message) {
		super(message);
	}
}
