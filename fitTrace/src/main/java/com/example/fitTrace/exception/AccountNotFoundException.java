package com.example.fitTrace.exception;

public class AccountNotFoundException extends RuntimeException{
  public AccountNotFoundException(String msg)
  {
	     super(msg);
  }
}
