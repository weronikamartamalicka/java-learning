package com.kodilla.hibernate.invoice;

import com.kodilla.hibernate.invoice.Invoice;
import com.kodilla.hibernate.invoice.Item;
import com.kodilla.hibernate.invoice.Product;
import com.kodilla.hibernate.invoice.dao.InvoiceDao;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@Transactional
@ExtendWith(SpringExtension.class)
public class InvoiceDaoTestSuite {

    @Autowired
    private InvoiceDao invoiceDao;

    @Test
    void testInvoiceDaoSave() {

        Product product = new Product("Malaga dress");
        Product product1 = new Product("Tampa suit");
        Product product2 = new Product("Tours sweater");
        Product product3 = new Product("Ferrara suit");

        Item item = new Item(product, new BigDecimal(550), 3);
        Item item1 = new Item(product3, new BigDecimal(650), 3);
        Item item2= new Item(product, new BigDecimal(550), 5);

        Invoice invoice = new Invoice("FF/21/09/2022");

        invoice.getItemList().add(item);
        invoice.getItemList().add(item1);
        invoice.getItemList().add(item2);

        item.setInvoice(invoice);
        item1.setInvoice(invoice);
        item2.setInvoice(invoice);

        invoiceDao.save(invoice);

        int id = invoice.getId();

        assertNotEquals(0, id);

        assertTrue(invoice.getItemList().containsAll(Arrays.asList(item, item1, item2)));
        assertTrue(product.getItemList().containsAll(Arrays.asList(item, item2)));

        try {
            invoiceDao.deleteById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
