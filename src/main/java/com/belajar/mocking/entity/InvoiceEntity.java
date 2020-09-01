package com.belajar.mocking.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity(name = "invoice")
@Setter
@Getter
public class InvoiceEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "invoice_generator")
    @SequenceGenerator(name="invoice_generator", sequenceName = "invoice_seq", allocationSize=50)
    private Integer id;
    private Integer totalAmount;
    private Integer discountPercentage;
    private Boolean status;
    @Transient
    List<InvoiceItemEntity> invoiceItemList;
}
