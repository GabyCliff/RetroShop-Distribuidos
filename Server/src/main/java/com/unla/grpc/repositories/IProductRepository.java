package com.unla.grpc.repositories;

import com.unla.grpc.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IProductRepository extends JpaRepository<Product,Long> {

}