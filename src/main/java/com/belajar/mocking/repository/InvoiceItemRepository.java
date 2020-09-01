package com.belajar.mocking.repository;

import com.belajar.mocking.entity.InvoiceItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface InvoiceItemRepository extends JpaRepository<InvoiceItemEntity, Long > {
    @Query("SELECT ii FROM invoice_item ii where ii.id=:id")
    InvoiceItemEntity findById(@Param("id") Integer id);
}
