package com.belajar.mocking.service;

import com.belajar.mocking.entity.InvoiceItemEntity;
import com.belajar.mocking.repository.InvoiceItemRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Service
public class InvoiceItemService {

    final
    InvoiceItemRepository itemRepository;

    public InvoiceItemService(InvoiceItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public InvoiceItemEntity save(InvoiceItemEntity itemEntity) {
        return itemRepository.save(itemEntity);
    }

    public InvoiceItemEntity update(Integer id, InvoiceItemEntity itemEntity) {
        Assert.notNull(itemRepository.findById(id), "Item Invoice Not Found");
        itemEntity.setId(id);
        return save(itemEntity);
    }

    public InvoiceItemEntity updateByItemIdAndInvoiceId(Integer id, InvoiceItemEntity itemEntity) {
        Assert.notNull(itemRepository.findById(id), "Item Invoice Not Found");
        itemEntity.setId(id);
        return save(itemEntity);
    }

}
