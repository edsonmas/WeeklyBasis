package weeklyBasis.servicos.excecao.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import weeklyBasis.servicos.excecao.EntityNotFoundException;
import weeklyBasis.servicos.excecao.EntityNotFoundExceptionDetails;

import java.time.LocalDate;

@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<EntityNotFoundExceptionDetails> handlerBadRequestException(EntityNotFoundException enfe){
        return new ResponseEntity<>(
                EntityNotFoundExceptionDetails.builder()
                        .timestamp(LocalDate.now())
                        .status(HttpStatus.BAD_REQUEST.value())
                        .title("Entity Not Found Exception")
                        .details(enfe.getMessage())
                        .developerMessage(enfe.getClass().getName())
                        .build(), HttpStatus.BAD_REQUEST);
    }


}
