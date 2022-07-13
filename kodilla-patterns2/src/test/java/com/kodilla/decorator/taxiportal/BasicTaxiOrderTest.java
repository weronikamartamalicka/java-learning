package com.kodilla.decorator.taxiportal;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class BasicTaxiOrderTest {

    @Test
    void testBasicTaxiOrderGetCost() {
        TaxiOrder basicTaxiOrder = new BasicTaxiOrder();

        BigDecimal cost = basicTaxiOrder.getCost();

        assertEquals(new BigDecimal(5.0), cost);

    }

    @Test
    void testBasicTaxiOrderGetDescription() {
        TaxiOrder theOrder = new BasicTaxiOrder();

        String description = theOrder.getDescription();

        assertEquals("Drive a course", description);
    }

    @Test
    public void testTaxiNetworkGetCost() {
        TaxiOrder theOrder = new BasicTaxiOrder();
        TaxiNetworkOrderDecorator orderDecorator = new TaxiNetworkOrderDecorator(theOrder);

        BigDecimal cost = orderDecorator.getCost();

        assertEquals(new BigDecimal(40.0), cost);
    }

    @Test
    public void testTaxiNetworkGetDescription() {
        TaxiOrder theOrder = new BasicTaxiOrder();
        TaxiNetworkOrderDecorator orderDecorator = new TaxiNetworkOrderDecorator(theOrder);

        String description = orderDecorator.getDescription();

        assertEquals("Drive a course by Taxi Network", description);

    }

    @Test
    public void testMyTaxiWithChildSeatGetCost() {
        TaxiOrder taxiOrder = new BasicTaxiOrder();
        taxiOrder = new UberNetworkOrderDecorator(taxiOrder);
        taxiOrder = new ChildSeatDecorator(taxiOrder);

        BigDecimal cost = taxiOrder.getCost();

        assertEquals(new BigDecimal(27.0), cost);
    }

}