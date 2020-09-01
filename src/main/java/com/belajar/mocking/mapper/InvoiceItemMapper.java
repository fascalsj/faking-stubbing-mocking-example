package com.belajar.mocking.mapper;

import com.belajar.mocking.dto.inbound.InvoiceItemInboundDto;
import com.belajar.mocking.dto.outbound.InvoiceItemOutboundDto;
import com.belajar.mocking.entity.InvoiceItemEntity;
import org.springframework.beans.BeanUtils;

public class InvoiceItemMapper {
    public InvoiceItemEntity invoiceInboundEntity(InvoiceItemInboundDto invoiceItemInboundDto){
        InvoiceItemEntity invoiceItemEntity = new InvoiceItemEntity();
        BeanUtils.copyProperties(invoiceItemInboundDto, invoiceItemEntity);
        return invoiceItemEntity;
    }

    public InvoiceItemOutboundDto invoiceEntityOutbound(InvoiceItemEntity invoiceItemEntity){
        InvoiceItemOutboundDto invoiceEntityOutbound = new InvoiceItemOutboundDto();
        BeanUtils.copyProperties(invoiceItemEntity, invoiceEntityOutbound);
        return invoiceEntityOutbound;
    }
}
