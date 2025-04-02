package cartoes_api.com.exception;

import cartoes_api.com.controller.dto.ErrorResponse;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptionHandler {

    private static final String APP_NAME = "cartoes_api";


    @ExceptionHandler(IdadeInvalidaException.class)
    public ResponseEntity<ErrorResponse> handleIdadeInvalidaException(IdadeInvalidaException ex) {
        ErrorResponse errorResponse = new ErrorResponse(
                "422",
                ex.getMessage(),
                new ErrorResponse.DetalheErro(
                        "Cartoes API",
                        "IDADE_INVALIDA",
                        "O cliente precisa ter pelo menos 18 anos."
                )
        );

        return new ResponseEntity<>(errorResponse, HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidationException(MethodArgumentNotValidException ex) {
        List<String> erros = ex.getBindingResult().getFieldErrors()
                .stream()
                .map(FieldError::getDefaultMessage)
                .collect(Collectors.toList());

        ErrorResponse errorResponse = new ErrorResponse(
                "400",
                "Erro de validação",
                new ErrorResponse.DetalheErro(
                        "Cartoes API",
                        "VALIDACAO_CAMPOS",
                        String.join("; ", erros)
                )
        );

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ErrorResponse> handleConstraintViolationException(ConstraintViolationException ex) {
        List<String> erros = ex.getConstraintViolations()
                .stream()
                .map(violation -> violation.getPropertyPath() + ": " + violation.getMessage())
                .collect(Collectors.toList());

        ErrorResponse errorResponse = new ErrorResponse(
                "400",
                "Erro de validação",
                new ErrorResponse.DetalheErro(
                        "Cartoes API",
                        "VALIDACAO_CAMPOS",
                        String.join("; ", erros)
                )
        );

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGenericException(Exception ex) {
        ErrorResponse errorResponse = new ErrorResponse(
                "500",
                "Um erro inesperado ocorreu.",
                new ErrorResponse.DetalheErro(
                        APP_NAME,
                        "SERVICO_INDISPONIVEL",
                        "Tivemos um problema, mas fique tranquilo que nosso time já foi avisado."
                )
        );

        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
