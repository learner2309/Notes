package com.example.fitTrace.exception;

public class UserNotFoundException extends RuntimeException{
   public UserNotFoundException(String msg)
   {
	   super(msg);
   }
}
