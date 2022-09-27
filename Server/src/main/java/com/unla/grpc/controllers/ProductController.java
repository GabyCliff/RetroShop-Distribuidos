package com.unla.grpc.controllers;

import com.unla.grpc.dtos.ProductDTO;
import com.unla.grpc.services.implementations.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
        return this.productService.updateProduct(product, id);
    }

    @GetMapping("/byIdUser/{idUser}")
    public List<ProductDTO> getProductByIdUser(@PathVariable  long idUser){
        return this.productService.getByIdUser(idUser);
    }

    @GetMapping("/getAll/{id}")
    public List<ProductDTO> getAllProducts(@PathVariable  long idUser){
        return this.productService.getAllProducts();
    }

}