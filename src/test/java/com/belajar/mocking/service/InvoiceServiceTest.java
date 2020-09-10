package com.belajar.mocking.service;

import com.belajar.mocking.entity.InvoiceEntity;
import com.belajar.mocking.entity.InvoiceItemEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class InvoiceServiceTest {

    @Autowired
    InvoiceService invoiceService;

    @Test
    void create() {
        InvoiceItemEntity invoiceItemEntityExpected = new InvoiceItemEntity();
        invoiceItemEntityExpected.setId(1);
        invoiceItemEntityExpected.setItemName("Jus Berenuk");
        invoiceItemEntityExpected.setPricePcs(13000);
        invoiceItemEntityExpected.setQty(2);
        invoiceItemEntityExpected.setIdInvoice(1);
        invoiceItemEntityExpected.setPriceTotal(26000);

        InvoiceItemEntity invoiceItemEntityExpected2 = new InvoiceItemEntity();
        invoiceItemEntityExpected2.setId(2);
        invoiceItemEntityExpected2.setIdInvoice(1);
        invoiceItemEntityExpected2.setItemName("Jus Nangka");
        invoiceItemEntityExpected2.setPricePcs(10000);
        invoiceItemEntityExpected2.setQty(2);
        invoiceItemEntityExpected2.setPriceTotal(20000);

        List<InvoiceItemEntity> invoiceItemEntitiesExpected = new ArrayList<>();
        invoiceItemEntitiesExpected.add(invoiceItemEntityExpected);
        invoiceItemEntitiesExpected.add(invoiceItemEntityExpected2);

        InvoiceEntity invoiceEntityExpected = new InvoiceEntity();
        invoiceEntityExpected.setId(1);
        invoiceEntityExpected.setDiscountPercentage(20);
        invoiceEntityExpected.setTotalAmount(36000);
        invoiceEntityExpected.setInvoiceItemList(invoiceItemEntitiesExpected);

        InvoiceItemEntity invoiceItemEntity = new InvoiceItemEntity();
        invoiceItemEntity.setItemName("Jus Berenuk");
        invoiceItemEntity.setPricePcs(13000);
        invoiceItemEntity.setQty(2);
        invoiceItemEntity.setIdInvoice(1);
        invoiceItemEntity.setPriceTotal(26000);

        InvoiceItemEntity invoiceItemEntity2 = new InvoiceItemEntity();
        invoiceItemEntity2.setItemName("Jus Nangka");
        invoiceItemEntity2.setPricePcs(10000);
        invoiceItemEntity2.setQty(2);
        invoiceItemEntity2.setIdInvoice(1);
        invoiceItemEntity2.setPriceTotal(20000);

        List<InvoiceItemEntity> invoiceItemEntities = new ArrayList<>();
        invoiceItemEntities.add(invoiceItemEntity);
        invoiceItemEntities.add(invoiceItemEntity2);

        InvoiceEntity invoiceEntity = new InvoiceEntity();
        invoiceEntity.setInvoiceItemList(invoiceItemEntities);
        invoiceEntity.setDiscountPercentage(20);
        invoiceEntity.setTotalAmount(36000);

        InvoiceEntity actual = invoiceService.create(invoiceEntity);

        Assertions.assertEquals(actual.getDiscountPercentage(), actual.getDiscountPercentage());
        Assertions.assertEquals(actual.getId(), invoiceEntityExpected.getId());
        Assertions.assertEquals(actual.getDiscountPercentage(), invoiceEntityExpected.getDiscountPercentage());
        Assertions.assertEquals(actual.getTotalAmount(), invoiceEntityExpected.getTotalAmount());
        Assertions.assertEquals(actual.getInvoiceItemList().get(0).getQty(), invoiceEntityExpected.getInvoiceItemList().get(0).getQty());
        Assertions.assertEquals(actual.getInvoiceItemList().get(0).getPriceTotal(), invoiceEntityExpected.getInvoiceItemList().get(0).getPriceTotal());
        Assertions.assertEquals(actual.getInvoiceItemList().get(0).getId(), invoiceEntityExpected.getInvoiceItemList().get(0).getId());
        Assertions.assertEquals(actual.getInvoiceItemList().get(0).getIdInvoice(), invoiceEntityExpected.getInvoiceItemList().get(0).getIdInvoice());
        Assertions.assertEquals(actual.getInvoiceItemList().get(0).getPricePcs(), invoiceEntityExpected.getInvoiceItemList().get(0).getPricePcs());
        Assertions.assertEquals(actual.getInvoiceItemList().get(0).getItemName(), invoiceEntityExpected.getInvoiceItemList().get(0).getItemName());

        Assertions.assertEquals(actual.getInvoiceItemList().get(1).getQty(), invoiceEntityExpected.getInvoiceItemList().get(1).getQty());
        Assertions.assertEquals(actual.getInvoiceItemList().get(1).getPriceTotal(), invoiceEntityExpected.getInvoiceItemList().get(1).getPriceTotal());
        Assertions.assertEquals(actual.getInvoiceItemList().get(1).getId(), invoiceEntityExpected.getInvoiceItemList().get(1).getId());
        Assertions.assertEquals(actual.getInvoiceItemList().get(1).getIdInvoice(), invoiceEntityExpected.getInvoiceItemList().get(1).getIdInvoice());
        Assertions.assertEquals(actual.getInvoiceItemList().get(1).getPricePcs(), invoiceEntityExpected.getInvoiceItemList().get(1).getPricePcs());
        Assertions.assertEquals(actual.getInvoiceItemList().get(1).getItemName(), invoiceEntityExpected.getInvoiceItemList().get(1).getItemName());

        Assertions.assertNotNull(actual.getCreatedDate());
    }
}