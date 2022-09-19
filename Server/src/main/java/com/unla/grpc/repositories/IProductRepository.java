package com.unla.grpc.repositories;

import com.unla.grpc.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IProductRepository extends JpaRepository<Product,Long> {

    List<Product> findByIdUser(Long idUser);

}