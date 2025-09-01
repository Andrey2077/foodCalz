package com.example.foodcalz.exception;

public class FoodDtoCreationException extends Exception{

    public static final String MESSAGE = "Food data response creation error";

    public FoodDtoCreationException(String message)
    {
        super(MESSAGE + message);
    }

}
