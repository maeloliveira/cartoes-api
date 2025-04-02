package cartoes_api.com.exception;

public class IdadeInvalidaException extends RuntimeException {

    public IdadeInvalidaException() {
        super("A idade do cliente deve ser maior ou igual a 18 anos.");
    }

}
