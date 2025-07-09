package types.result;

import java.util.function.Function;

public class Err<T, E> implements Result<T, E> {
	private final E error;

	public Err(E error) {
		this.error = error;
	}

	@Override
	public boolean isOk() {
		return false;
	}

	@Override
	public boolean isErr() {
		return true;
	}

	@Override
	public T unwrap() {
		throw new IllegalStateException("Tried to unwrap() on an Err");
	}

	@Override
	public E unwrapErr() {
		return this.error;
	}

	@Override
	public <U> Result<U, E> map(Function<T, U> mapper) {
		return new Err<>(error); // no value to map
	}

	@Override
	public <F> Result<T, F> mapErr(Function<E, F> mapper) {
		return new Err<>(mapper.apply(error));
	}

	@Override
	public <U> Result<U, E> andThen(Function<T, Result<U, E>> fn) {
		return new Err<>(error); // cannot chain on error values
	}
}
