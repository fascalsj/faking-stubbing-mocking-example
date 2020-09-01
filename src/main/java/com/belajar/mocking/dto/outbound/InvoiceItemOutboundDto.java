package com.belajar.mocking.dto.outbound;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class InvoiceItemOutboundDto {
    private Integer id;
    private Integer idInvoice;
    private Integer itemId;
    private String itemName;
    private Integer qty;
    private Integer pricePcs;
    private Integer priceTotal;

}
