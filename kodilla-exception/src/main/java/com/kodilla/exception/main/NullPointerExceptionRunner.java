package com.kodilla.exception.main;

import com.kodilla.exception.nullpointer.MessageNotSentException;
import com.kodilla.exception.nullpointer.MessageSender;
import com.kodilla.exception.nullpointer.User;

public class NullPointerExceptionRunner {

    public static void main(String[] args) {
        User user = null;
        MessageSender messageSender = new MessageSender();

        try {
            messageSender.sendMessageTo(user, "Hello!");
        } catch(MessageNotSentException e) {
            System.out.println("Message is not send: " + e);
        } finally {
            System.out.println("Processing other logic!");
        }
    }
}
