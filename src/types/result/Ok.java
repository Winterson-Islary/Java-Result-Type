package types.result;

import java.util.function.Function;

public class Ok<T, E> implements Result<T, E> {

	private final T value;

	public Ok(T value) {
		this.value = value;
	}

	@Override
	public boolean isOk() {
		return true;
	}

	@Override
	public boolean isErr() {
		return false;
	}

	@Override
	public T unwrap() {
		return this.value;
	}

	@Override
	public E unwrapErr() {
		throw new IllegalStateException("Tried to unwrapErr() on an Ok");
	}

	@Override
	public <U> Result<U, E> map(Function<T, U> mapper) {
		return new Ok<>(mapper.apply(value));
	}

	@Override
	public <F> Result<T, F> mapErr(Function<E, F> mapper) {
		return new Ok<>(value); // no error values to map
	}

	@Override
	public <U> Result<U, E> andThen(Function<T, Result<U, E>> fn) {
		return fn.apply(value);
	}
}
