package com.belajar.mocking.service;

import com.belajar.mocking.client.HistoryClient;
import com.belajar.mocking.dto.inbound.HistoryInboundDto;
import com.belajar.mocking.dto.outbound.HistoryOutboundDto;
import com.belajar.mocking.entity.InvoiceItemEntity;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
class HistoryServiceTest {
    @InjectMocks
    HistoryService historyService;

    @Mock
    private HistoryClient historyClient;

    Integer id = 1;
    Integer invoiceId = 1;
    String itemName = "litter box";
    Integer pricePcs = 10000;
    Integer qty = 10;
    Integer priceTotal = 100000;

    @Captor
    ArgumentCaptor<HistoryOutboundDto> historyOutboundDtoArgumentCaptor;

    @Test
    public void createHistory() throws JsonProcessingException {
        Date date = new Date();
        HistoryInboundDto historyInboundDto = new HistoryInboundDto();
        historyInboundDto.setComplete(true);
        historyInboundDto.setId(id);
        historyInboundDto.setPetId(invoiceId);
        historyInboundDto.setQuantity(qty);
        historyInboundDto.setShipDate(date);
        historyInboundDto.setStatus("placed");

        HistoryOutboundDto historyOutboundDto = new HistoryOutboundDto();
        historyOutboundDto.setComplete(true);
        historyOutboundDto.setId(id);
        historyOutboundDto.setPetId(invoiceId);
        historyOutboundDto.setQuantity(qty);
        historyOutboundDto.setShipDate(date);
        historyOutboundDto.setStatus("placed");


        InvoiceItemEntity invoiceItemEntity = new InvoiceItemEntity();
        invoiceItemEntity.setId(id);
        invoiceItemEntity.setIdInvoice(invoiceId);
        invoiceItemEntity.setItemName(itemName);
        invoiceItemEntity.setPricePcs(pricePcs);
        invoiceItemEntity.setQty(qty);
        invoiceItemEntity.setPriceTotal(priceTotal);
        invoiceItemEntity.setCreatedDate(date);
        invoiceItemEntity.setUpdatedDate(date);
        invoiceItemEntity.setItemId(1);

        Mockito.when(historyClient.createHistory(historyOutboundDtoArgumentCaptor.capture())).thenReturn(historyInboundDto);

        historyService.createHistory(invoiceItemEntity);

        Assertions.assertEquals(historyOutboundDto.getComplete(), historyOutboundDtoArgumentCaptor.getValue().getComplete());
        Assertions.assertEquals(historyOutboundDto.getPetId(), historyOutboundDtoArgumentCaptor.getValue().getPetId());
        Assertions.assertEquals(historyOutboundDto.getQuantity(), historyOutboundDtoArgumentCaptor.getValue().getQuantity());
        Assertions.assertEquals(historyOutboundDto.getShipDate(), historyOutboundDtoArgumentCaptor.getValue().getShipDate());
    }

}