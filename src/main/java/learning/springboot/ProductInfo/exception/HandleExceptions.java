package learning.springboot.ProductInfo.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class HandleExceptions {
	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<?> notFoundHandling(NotFoundException exception, WebRequest request) {
		Errors errors = new Errors(new Date(), exception.getMessage(),request.getDescription(false));
		return new ResponseEntity<>(errors,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?>handleExceptions(Exception exception,WebRequest request){
		Errors errors = new Errors(new Date(), exception.getMessage(),request.getDescription(false));
		return new ResponseEntity<>(errors,HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
