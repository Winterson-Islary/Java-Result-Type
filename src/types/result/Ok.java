package types.result;

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
}
