package br.com.serratec.livraria.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ValidationHandler extends ResponseEntityExceptionHandler {

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			org.springframework.http.HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		
		List<String> erros = ex.getBindingResult().getFieldErrors()
				.stream()
				.map(e -> e.getField() + " - " + e.getDefaultMessage())
				.collect(Collectors.toList());
		
		return new ResponseEntity<Object>(erros, HttpStatus.NOT_ACCEPTABLE);
	}
	
	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<Object> handleException(HttpServletRequest request, Exception ex){
	    return new ResponseEntity<Object>(ex.getMessage(), HttpStatus.NOT_ACCEPTABLE);
	}
	
	
}
