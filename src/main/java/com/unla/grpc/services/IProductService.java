package com.unla.grpc.services;

import com.unla.grpc.dtos.ProductDTO;
import com.unla.grpc.models.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

@Repository("productService")
public interface IProductService {

    public ProductDTO getProduct(Long id);
    public ResponseEntity<String> saveProduct(ProductDTO product);
    public ResponseEntity<String> updateProducto(ProductDTO product, long id);
}
