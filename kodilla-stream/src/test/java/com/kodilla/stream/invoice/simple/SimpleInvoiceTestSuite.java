package com.kodilla.stream.invoice.simple;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SimpleInvoiceTestSuite {

    @Test
    void testGetValueToPay() {
        SimpleInvoice invoice = new SimpleInvoice();

        invoice.addItem(new SimpleItem(new SimpleProduct("Product 1", 17.28), 2.0));
        invoice.addItem(new SimpleItem(new SimpleProduct("Product 2", 11.99), 3.5));
        invoice.addItem(new SimpleItem(new SimpleProduct("Product 3",  6.49), 5.0));

        assertEquals(108.975, invoice.getValueToPay(), 0.001);
    }
}
