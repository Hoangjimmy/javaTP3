package tp3;

public interface ParserFactory<T> {
	public abstract T tryConstruct(String[] args);
}
