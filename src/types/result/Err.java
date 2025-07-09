package types.result;

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

}
