package com.belajar.mocking.controller;

import com.belajar.mocking.dto.inbound.InvoiceInboundDto;
import com.belajar.mocking.dto.outbound.InvoiceOutboundDto;
import com.belajar.mocking.entity.InvoiceEntity;
import com.belajar.mocking.mapper.InvoiceItemMapper;
import com.belajar.mocking.mapper.InvoiceMapper;
import com.belajar.mocking.service.InvoiceService;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class InvoiceController {

final
InvoiceService invoiceService;

    public InvoiceController(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    @PostMapping("/invoice")
    public HttpEntity<InvoiceOutboundDto> create(@RequestBody InvoiceInboundDto invoiceInboundDto) {
        InvoiceMapper invoiceMapper = new InvoiceMapper(new InvoiceItemMapper());
        InvoiceEntity invoiceEntityCreated = invoiceService.create(invoiceMapper.invoiceInboundEntity(invoiceInboundDto));
        InvoiceOutboundDto invoiceItemOutboundDto = invoiceMapper.invoiceEntityOutboundDto(invoiceEntityCreated);
        return ResponseEntity.ok(invoiceItemOutboundDto);
    }
}
