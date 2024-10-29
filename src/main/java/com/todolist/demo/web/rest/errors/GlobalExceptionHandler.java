package com.todolist.demo.web.rest.errors;

import org.springframework.http.*;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler  {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> handleResourceNotFoundException(ResourceNotFoundException ex) {
        ErrorRespone error = new ErrorRespone(ex.getLocalizedMessage(), Arrays.asList(ex.getMessage()));
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(error);
    }


    @ExceptionHandler(DuplicateRecordException.class)
    public ResponseEntity<?> handleDuplicateException(DuplicateRecordException ex) {
        ErrorRespone error = new ErrorRespone(ex.getLocalizedMessage(), Arrays.asList(ex.getMessage()));
        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(error);
    }

//    @ExceptionHandler(Exception.class)
//    public ResponseEntity<String> handleGlobalException(Exception ex) {
//        return new ResponseEntity<>("An error occurred: " + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
//    }


    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        List<String> errors = new ArrayList<String>();
        for (FieldError error: ex.getBindingResult().getFieldErrors()){
            errors.add(error.getDefaultMessage());
        }

        for (ObjectError error: ex.getBindingResult().getFieldErrors()){
            errors.add(error.getDefaultMessage());
        }

        ErrorRespone errorResponse = new ErrorRespone("Server Error", errors);
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(errorResponse);
        }
//
//    public final ResponseEntity<ErrorResponse> handleAllExceptions (Exception ex, WebRequest request){
//        List<String> details = new ArrayList<>();
//        details.add(ex.getLocalizedMessage());
//
//        return new ResponseEntity(error,HttpStatus.INTERNAL_SERVER_ERROR);
//    }
//
//
//    // You can add more exception handlers here
}
