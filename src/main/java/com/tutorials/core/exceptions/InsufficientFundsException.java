package com.tutorials.core.exceptions;

// Checked: extends Exception, not RuntimeException. Callers of Account.withdraw()
// are FORCED by the compiler to either catch this or declare it — appropriate
// for a recoverable business condition the caller is expected to handle.
public class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String message) {
        super(message);
    }
}
