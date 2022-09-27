package com.unla.grpc.repositories;

import com.unla.grpc.models.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
    
    Optional<Invoice> findByIdBuyer(long idBuyer);

    Optional<Invoice> findByIdSeller(long idSeller);

}
