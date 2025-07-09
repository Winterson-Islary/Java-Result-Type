import models.errors.UserError;
import services.user.UserService;
import types.result.Result;

public class Main {
	public static void main(String args[]) {
		System.out.println("This is a test for Result type implementation in Java");
		UserService userService = new UserService();
		Result<String, UserError> result = userService.getUserById(1);

		if (result.isOk())
			System.out.println("User: " + result.map(value -> value.toUpperCase()).unwrap());
		else {
			UserError error = result.unwrapErr();
			System.out.println("Error [" + error.getCode() + "]: " + error.getMessage());
		}
	}
}
