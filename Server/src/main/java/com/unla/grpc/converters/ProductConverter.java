package com.unla.grpc.converters;

import com.unla.grpc.dtos.ProductDTO;
import com.unla.grpc.models.Product;
import com.unla.retroshopservicegrpc.grpc.ProductResponse;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class ProductConverter {


    public ProductConverter(){

    }

    public static Product fromProductDTO_to_Product(ProductDTO productDTO){
        Product product = new Product();
        product.setName(productDTO.getName());
        product.setDate(productDTO.getDate());
        product.setPhotos(productDTO.getPhotos());
        product.setCategory(productDTO.getCategory());
        product.setPrice(productDTO.getPrice());
        product.setQuantity(productDTO.getQuantity());

        return product;
    }

    public static ProductDTO fromProduct_to_ProductDTO(Product product){
        ProductDTO productDTO = new ProductDTO();
        productDTO.setName(product.getName());
        productDTO.setDate(product.getDate());
        productDTO.setPhotos(product.getPhotos());
        productDTO.setCategory(product.getCategory());
        productDTO.setPrice(product.getPrice());
        productDTO.setQuantity(product.getQuantity());

        return productDTO;
    }

}
