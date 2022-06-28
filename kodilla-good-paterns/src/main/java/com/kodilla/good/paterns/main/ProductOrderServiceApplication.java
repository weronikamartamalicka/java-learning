package com.kodilla.good.paterns.main;

import com.kodilla.good.paterns.challenges.*;
import com.kodilla.good.paterns.good.patterns.challenges.*;

public class ProductOrderServiceApplication {

    public static void main(String[] args) {
        ProductOrderProcessor processor = new ProductOrderProcessor(new MailService(), new TimberlandRepository(), new ProductOrderService());
        OrderRequestRetriever orderRequestRetriever = new OrderRequestRetriever();
        OrderRequest orderRequest = orderRequestRetriever.retrieve();
        processor.process(orderRequest);
    }
}
