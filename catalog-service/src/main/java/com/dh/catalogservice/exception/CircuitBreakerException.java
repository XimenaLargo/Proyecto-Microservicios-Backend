package com.dh.catalogservice.exception;

public class CircuitBreakerException extends Exception{

    public CircuitBreakerException (String message){
        super(message);
    }


}
