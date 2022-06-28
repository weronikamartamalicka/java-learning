package com.kodilla.good.paterns.exception.nullpointer;

public class MessageNotSentException extends Exception {

    public MessageNotSentException(final String message) {
        super(message);
    }
}
