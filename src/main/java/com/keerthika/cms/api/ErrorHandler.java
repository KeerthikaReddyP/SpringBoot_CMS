package com.keerthika.cms.api;

import com.keerthika.cms.exceptionHandling.ApplicationError;
import com.keerthika.cms.exceptionHandling.CustomerNotFoundException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class ErrorHandler extends ResponseEntityExceptionHandler {

    @Value("${api_doc_url}")
    private String details;

    @ExceptionHandler(CustomerNotFoundException.class)
    public ResponseEntity<ApplicationError> customerNotFoundExceptionHandler(CustomerNotFoundException exception, WebRequest webReq){

        ApplicationError err=new ApplicationError();
        err.setCode(101);
        err.setMessage(exception.getMessage());
        err.setDetails(details);

        return new ResponseEntity<>(err, HttpStatus.NOT_FOUND);
    }
}
