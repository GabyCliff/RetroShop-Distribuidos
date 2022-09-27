package com.unla.grpc.services.interfaces;

import com.unla.grpc.dtos.ProductDTO;
import com.unla.retroshopservicegrpc.grpc.ProductResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("productService")
public interface IProductService {

    public ProductDTO getProduct(Long id);
    public ResponseEntity<String> saveProduct(ProductDTO product);
    public ResponseEntity<String> updateProduct(ProductDTO product, long id);

    List<ProductDTO> getByIdUser(long idUserInProduct);

    ProductResponse getProductResponseById(long id);

    List<ProductDTO> getAllProducts();

}