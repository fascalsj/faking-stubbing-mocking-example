package com.belajar.mocking.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity(name = "invoice_item")
@Setter
@Getter
public class InvoiceItemEntity extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "invoice_item_generator")
    @SequenceGenerator(name="invoice_item_generator", sequenceName = "invoice_item_seq", allocationSize=50)
    private Integer id;
    private Integer idInvoice;
    private Integer itemId;
    private String itemName;
    private Integer qty;
    private Integer pricePcs;
    private Integer priceTotal;
}
