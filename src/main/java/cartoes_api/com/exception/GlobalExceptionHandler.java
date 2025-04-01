//package cartoes_api.com.exception;
//
//import cartoes_api.com.controller.dto.ErrorResponse;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//
//import javax.servlet.http.HttpServletRequest;
//
//@ControllerAdvice
//public class GlobalExceptionHandler {
//
//    public GlobalExceptionHandler(String s) {
//    }
//
//    @ExceptionHandler(IdadeInvalidaException.class)
//    public ResponseEntity<ErrorResponse> handleIdadeInvalidaException(IdadeInvalidaException ex, HttpServletRequest request) {
//        ErrorResponse errorResponse = new ErrorResponse(
//                HttpStatus.BAD_REQUEST.value(),
//                "Bad Request",
//                ex.getMessage(),
//                request.getRequestURI()
//        );
//        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
//    }
//
//    @ExceptionHandler(IllegalArgumentException.class)
//    public ResponseEntity<ErrorResponse> handleIllegalArgumentException(IllegalArgumentException ex, HttpServletRequest request) {
//        ErrorResponse errorResponse = new ErrorResponse(
//                HttpStatus.UNPROCESSABLE_ENTITY.value(),
//                "Unprocessable Entity",
//                ex.getMessage(),
//                request.getRequestURI()
//        );
//        return new ResponseEntity<>(errorResponse, HttpStatus.UNPROCESSABLE_ENTITY);
//    }
//
//    @ExceptionHandler(IllegalStateException.class)
//    public ResponseEntity<ErrorResponse> handleIllegalStateException(IllegalStateException ex, HttpServletRequest request) {
//        ErrorResponse errorResponse = new ErrorResponse(
//                HttpStatus.NO_CONTENT.value(),
//                "No Content",
//                ex.getMessage(),
//                request.getRequestURI()
//        );
//        return new ResponseEntity<>(errorResponse, HttpStatus.NO_CONTENT);
//    }
//
//    @ExceptionHandler(Exception.class)
//    public ResponseEntity<ErrorResponse> handleException(Exception ex, HttpServletRequest request) {
//        ErrorResponse errorResponse = new ErrorResponse(
//                HttpStatus.BAD_REQUEST.value(),
//                "Bad Request",
//                "Erro interno no servidor.",
//                request.getRequestURI()
//        );
//        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
//    }
//}
