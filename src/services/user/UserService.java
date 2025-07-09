package services.user;

import models.errors.UserError;
import types.result.*;

public class UserService {
	public Result<String, UserError> getUserById(int id) {
		if (id == 1)
			return new Ok<String, UserError>("Winterson");
		else
			return new Err<String, UserError>(new UserError("User not found", 404));
	}
}
