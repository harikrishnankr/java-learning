package com.tutorials.core.exceptions;

// Unchecked: extends RuntimeException — for programmer errors (bad arguments)
// that callers shouldn't be forced to catch everywhere; they should fix the
// call site instead.
public class InvalidAccountException extends RuntimeException {
    public InvalidAccountException(String message) {
        super(message);
    }
}
