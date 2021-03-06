package com.belajar.mocking.service;

import com.belajar.mocking.entity.InvoiceItemEntity;
import com.belajar.mocking.repository.InvoiceItemRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class InvoiceItemServiceTest {

    @InjectMocks
    InvoiceItemService invoiceItemService;

    @Mock
    InvoiceItemRepository invoiceItemRepository;

    Integer id = 1;
    Integer invoiceId = 1;
    String itemName = "litter box";
    Integer pricePcs = 10000;
    Integer qty = 10;
    Integer priceTotal = 100000;

    @Test
    void create() {

        //Contoh Stubbing
        //Data Expected
        InvoiceItemEntity itemExpected = new InvoiceItemEntity();
        itemExpected.setId(id);
        itemExpected.setIdInvoice(invoiceId);
        itemExpected.setItemName(itemName);
        itemExpected.setPricePcs(pricePcs);
        itemExpected.setQty(qty);
        itemExpected.setPriceTotal(priceTotal);

        //Data Input
        InvoiceItemEntity itemEntity = new InvoiceItemEntity();
        itemEntity.setId(id);
        itemEntity.setIdInvoice(invoiceId);
        itemEntity.setItemName(itemName);
        itemEntity.setPricePcs(pricePcs);
        itemEntity.setQty(qty);
        itemEntity.setPriceTotal(priceTotal);

        Mockito.when(invoiceItemRepository.save(Mockito.any(InvoiceItemEntity.class))).thenReturn(itemExpected);

        InvoiceItemEntity actual = invoiceItemService.save(itemEntity);

        Assertions.assertEquals(actual.getId(), itemExpected.getId());
        Assertions.assertEquals(actual.getIdInvoice(), itemExpected.getIdInvoice());
        Assertions.assertEquals(actual.getItemName(), itemExpected.getItemName());
        Assertions.assertEquals(actual.getPricePcs(), itemExpected.getPricePcs());
        Assertions.assertEquals(actual.getQty(), itemExpected.getQty());
        Assertions.assertEquals(actual.getPriceTotal(), itemExpected.getPriceTotal());

    }

    @Test
    void update() {
        //Contoh Stubbing
        //Data Expected
        InvoiceItemEntity itemExpected = new InvoiceItemEntity();
        itemExpected.setId(id);
        itemExpected.setIdInvoice(invoiceId);
        itemExpected.setItemName(itemName);
        itemExpected.setPricePcs(pricePcs);
        itemExpected.setQty(qty);
        itemExpected.setPriceTotal(priceTotal);

        InvoiceItemEntity itemEntity = new InvoiceItemEntity();
        itemEntity.setIdInvoice(invoiceId);
        itemEntity.setItemName(itemName);
        itemEntity.setPricePcs(pricePcs);
        itemEntity.setQty(qty);
        itemEntity.setPriceTotal(priceTotal);

        Mockito.when(invoiceItemRepository.findById(Mockito.anyInt())).thenReturn(itemExpected);
        Mockito.when(invoiceItemRepository.save(Mockito.any(InvoiceItemEntity.class))).thenReturn(itemExpected);

        InvoiceItemEntity actual = invoiceItemService.update(id, itemEntity);

        Assertions.assertEquals(actual.getId(), itemExpected.getId());
        Assertions.assertEquals(actual.getIdInvoice(), itemExpected.getIdInvoice());
        Assertions.assertEquals(actual.getItemName(), itemExpected.getItemName());
        Assertions.assertEquals(actual.getPricePcs(), itemExpected.getPricePcs());
        Assertions.assertEquals(actual.getQty(), itemExpected.getQty());
        Assertions.assertEquals(actual.getPriceTotal(), itemExpected.getPriceTotal());
    }

}