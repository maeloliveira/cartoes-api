package cartoes_api.com.exception;

public class IdadeInvalidaException extends RuntimeException {

    public IdadeInvalidaException() {
        super("A idade do cliente deve ser maior ou igual a 18 anos.");
    }

    public IdadeInvalidaException(String message) {
        super(message);
    }

    public IdadeInvalidaException(String message, Throwable cause) {
        super(message, cause);
    }

    public IdadeInvalidaException(Throwable cause) {
        super(cause);
    }
}
