package com.example.foodcalz.exception;

public class FoodNotFoundException extends Exception{

    public static final String MESSAGE = "Food not found";

    public FoodNotFoundException(String message)
    {
        super(MESSAGE + message);
    }

}
