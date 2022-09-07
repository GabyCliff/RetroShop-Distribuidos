package com.unla.grpc.controllers;

import com.unla.grpc.dtos.ProductDTO;
import com.unla.grpc.models.Product;
import com.unla.grpc.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/get/{id}")
    public ProductDTO gerProduct(@PathVariable  Long id){
        return this.productService.getProduct(id);
    }

    @PostMapping("/save")
    public ResponseEntity<String> saveProduct(@RequestBody ProductDTO product) {
        return this.productService.saveProduct(product);
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<String> updateProduct(@RequestBody ProductDTO product,@PathVariable long id){
        return this.productService.updateProducto(product,id);
    }
}
