package com.example.fitTrace.exception;

import java.time.LocalDateTime;
import java.util.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
   @ExceptionHandler(UserNotFoundException.class)
   public ResponseEntity<Map<String,Object>> handleUserNotFoundException(UserNotFoundException ex)
   {
	   Map<String,Object> response = new HashMap<>();
	   response.put("message",ex.getMessage());
	   response.put("statuscode",HttpStatus.NOT_FOUND.value());
	   response.put("time", LocalDateTime.now());
	   return new  ResponseEntity<>(response,HttpStatus.NOT_FOUND);
   }
@ExceptionHandler(AccountNotFoundException.class)
public ResponseEntity<Map<String,Object>> HandleAccountNotFoundException(AccountNotFoundException ex)
{
	Map<String , Object> map = new HashMap<String,Object>();
	map.put("message",ex.getMessage());
	map.put("status",HttpStatus.NOT_FOUND.value());
	map.put("time", LocalDateTime.now());
	return new ResponseEntity<>(map,HttpStatus.NOT_FOUND);
}
}
