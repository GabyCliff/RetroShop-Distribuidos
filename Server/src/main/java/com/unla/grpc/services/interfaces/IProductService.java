package com.unla.grpc.services.interfaces;

import com.unla.grpc.dtos.ProductDTO;
import com.unla.retroshopservicegrpc.grpc.ProductResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("productService")
public interface IProductService {

    ProductDTO getProduct(Long id);

    String saveProduct(ProductDTO product);

    ResponseEntity<String> updateProduct(ProductDTO product, long id);

    List<ProductDTO> getByIdUser(long idUserInProduct);

    List<ProductDTO> getAllByListIds(List<Long> ids);

    ProductResponse getProductResponseById(long id);

    List<ProductDTO> getAllProducts();

}