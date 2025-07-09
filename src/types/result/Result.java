package types.result;

import java.util.function.Function;

public interface Result<T, E> {
	boolean isOk();

	boolean isErr();

	T unwrap(); // Will throw if Err

	E unwrapErr(); // Will throw if Ok

	<U> Result<U, E> map(Function<T, U> mapper);

	<F> Result<T, F> mapErr(Function<E, F> mapper);

	<U> Result<U, E> andThen(Function<T, Result<U, E>> fn);
}