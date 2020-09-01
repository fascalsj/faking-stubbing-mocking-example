package com.belajar.mocking.repository;

import com.belajar.mocking.entity.InvoiceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRepository extends JpaRepository<InvoiceEntity, Long > {
}
