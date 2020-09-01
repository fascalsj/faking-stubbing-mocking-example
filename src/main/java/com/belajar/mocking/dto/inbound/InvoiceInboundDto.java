package com.belajar.mocking.dto.inbound;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class InvoiceInboundDto {
    private Integer id;
    private Integer totalAmount;
    private Integer discountPercentage;
    private Boolean status;
    private List<InvoiceItemInboundDto> invoiceItemList;
}
