package com.belajar.mocking.dto.inbound;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class HistoryInboundDto {
    private Integer id;
    private Integer petId;
    private Integer quantity;
    private Date shipDate;
    private String status;
    private Boolean complete;
}