package com.example.grocerystore.exceptions;

public class GroceryNotFoundException extends RuntimeException {
    public GroceryNotFoundException(String id) {
        super("Could not find grocery with an id of " + id);
    }
}
