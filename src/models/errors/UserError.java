package models.errors;

public class UserError {
	private final String message;
	private final int code;

	public UserError(String message, int code) {
		this.message = message;
		this.code = code;
	}

	public String getMessage() {
		return this.message;
	}

	public int getCode() {
		return this.code;
	}

	@Override
	public String toString() {
		return "UserError{ code = " + code + ", message = '" + message + "'}";
	}
}
