package com.unla.grpc.services;

import com.unla.grpc.dtos.ProductDTO;
import com.unla.grpc.models.Product;
import com.unla.grpc.repositories.IProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service("productService")
public class ProductService implements IProductService{

    ModelMapper modelMapper = new ModelMapper();

    @Autowired
    private IProductRepository productRepository;

    @Override
    public ProductDTO getProduct(Long id) {
        Product aux = productRepository.findById(id).get();
        ProductDTO productDTO = modelMapper.map(aux,ProductDTO.class);
        return productDTO;
    }

    @Override
    public ResponseEntity<String> saveProduct(ProductDTO product) {
        Product aux = modelMapper.map(product,Product.class);
        if(product.getPhotos().size() > 5){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("El producto no fue agregado porque tiene mas de 5 fotos");
        }else if(product.getPhotos().size() <= 1){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("El producto no fue agregado porque tiene menos de 1 foto");
        }
        productRepository.save(aux);
        return ResponseEntity.status(HttpStatus.CREATED).body("El producto fue agregado correcatamente");
    }

    @Override
    public ResponseEntity<String> updateProducto(ProductDTO product,long id) {
        Product aux = modelMapper.map(product, Product.class);
        aux.setId(id);
        productRepository.save(aux);
        return ResponseEntity.status(HttpStatus.OK).body("El producto fue actualizado correctamente");
    }

}