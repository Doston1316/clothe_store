package uz.dosya.marketapp.error;

import javassist.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?>handlerException(Exception exception, WebRequest request){
        ErrorDetails errorDetails=new ErrorDetails(exception.getMessage(),request.getDescription(true));
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?>handlerNotFoundException(NotFoundException exception, WebRequest request){
        ErrorDetails errorDetails=new ErrorDetails(exception.getMessage(),request.getDescription(true));
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }
}
