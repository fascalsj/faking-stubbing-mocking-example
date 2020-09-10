package com.belajar.mocking.service;

import com.belajar.mocking.client.HistoryClient;
import com.belajar.mocking.dto.outbound.HistoryOutboundDto;
import com.belajar.mocking.entity.InvoiceItemEntity;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.stereotype.Service;

@Service
public class HistoryService {

    final
    HistoryClient historyClient;

    public HistoryService(HistoryClient historyClient) {
        this.historyClient = historyClient;
    }

    public void createHistory(InvoiceItemEntity invoiceItemEntity) throws JsonProcessingException {
        HistoryOutboundDto historyOutboundDto = new HistoryOutboundDto();
        historyOutboundDto.setPetId(invoiceItemEntity.getId());
        historyOutboundDto.setQuantity(invoiceItemEntity.getQty());
        historyOutboundDto.setShipDate(invoiceItemEntity.getUpdatedDate());
        historyOutboundDto.setStatus("History Recorded");
        historyOutboundDto.setComplete(true);

        historyClient.createHistory(historyOutboundDto);
    }
}
