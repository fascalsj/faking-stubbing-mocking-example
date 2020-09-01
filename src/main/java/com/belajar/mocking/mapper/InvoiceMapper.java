package com.belajar.mocking.mapper;

import com.belajar.mocking.dto.inbound.InvoiceInboundDto;
import com.belajar.mocking.dto.inbound.InvoiceItemInboundDto;
import com.belajar.mocking.dto.outbound.InvoiceItemOutboundDto;
import com.belajar.mocking.dto.outbound.InvoiceOutboundDto;
import com.belajar.mocking.entity.InvoiceEntity;
import com.belajar.mocking.entity.InvoiceItemEntity;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

public class InvoiceMapper {
    final
    InvoiceItemMapper invoiceEntityMapper;

    public InvoiceMapper(InvoiceItemMapper invoiceEntityMapper) {
        this.invoiceEntityMapper = invoiceEntityMapper;
    }

    public InvoiceEntity invoiceInboundEntity(InvoiceInboundDto invoiceInboundDto) {
        InvoiceEntity invoiceEntity = new InvoiceEntity();
        BeanUtils.copyProperties(invoiceInboundDto, invoiceEntity);
        if (null != invoiceInboundDto.getInvoiceItemList()) {
            List<InvoiceItemEntity> invoiceItemEntityList = new ArrayList<>();
            for (InvoiceItemInboundDto invoiceItemInboundDto : invoiceInboundDto.getInvoiceItemList()) {
                invoiceItemEntityList.add(invoiceEntityMapper.invoiceInboundEntity(invoiceItemInboundDto));
            }
            invoiceEntity.setInvoiceItemList(invoiceItemEntityList);
        }
        return invoiceEntity;
    }

    public InvoiceOutboundDto invoiceEntityOutboundDto(InvoiceEntity invoiceEntity) {
        InvoiceOutboundDto invoiceOutboundDto = new InvoiceOutboundDto();
        BeanUtils.copyProperties(invoiceEntity, invoiceOutboundDto);
        if (null != invoiceEntity.getInvoiceItemList()) {
            List<InvoiceItemOutboundDto> invoiceItemOutboundDtoList = new ArrayList<>();
            for (InvoiceItemEntity invoiceItemEntity : invoiceEntity.getInvoiceItemList()) {
                invoiceItemOutboundDtoList.add(invoiceEntityMapper.invoiceEntityOutbound(invoiceItemEntity));
            }
            invoiceOutboundDto.setInvoiceItemList(invoiceItemOutboundDtoList);
        }
        return invoiceOutboundDto;
    }
}
