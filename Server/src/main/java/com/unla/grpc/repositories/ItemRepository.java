package com.unla.grpc.repositories;

import com.unla.grpc.models.Item;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ItemRepository extends JpaRepository<Item, Long> {

    Optional<Item> findByIdInvoice(long idInvoice);

    List<Item> findAllByIdInvoice(long idInvoice);

}
