package types.result;

public interface Result<T, E> {
	boolean isOk();
	boolean isErr();

	T unwrap(); // Will throw if Err
	E unwrapErr(); // Will throw if Ok
}