package com.belajar.mocking.service;

import com.belajar.mocking.entity.InvoiceEntity;
import com.belajar.mocking.entity.InvoiceItemEntity;
import com.belajar.mocking.repository.InvoiceRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InvoiceService {
    final InvoiceRepository invoiceRepository;
    final InvoiceItemService invoiceItemService;

    public InvoiceService(InvoiceRepository invoiceRepository, InvoiceItemService invoiceItemService) {
        this.invoiceRepository = invoiceRepository;
        this.invoiceItemService = invoiceItemService;
    }

    public InvoiceEntity create(InvoiceEntity invoiceEntity) {
        InvoiceEntity invoiceEntityCreated = invoiceRepository.save(invoiceEntity);
        if (null!=invoiceEntity.getInvoiceItemList()){
            List<InvoiceItemEntity> invoiceItemEntityList = new ArrayList<>();
            for (InvoiceItemEntity invoiceItemEntity : invoiceEntity.getInvoiceItemList()) {
                InvoiceItemEntity invoiceItemEntityCreated = invoiceItemService.save(invoiceItemEntity);
                invoiceItemEntityList.add(invoiceItemEntityCreated);
            }
            invoiceEntityCreated.setInvoiceItemList(invoiceItemEntityList);
        }
        return invoiceEntityCreated;
    }

    public InvoiceEntity update(Integer id, InvoiceEntity invoiceEntity) {
        return null;
    }

}
