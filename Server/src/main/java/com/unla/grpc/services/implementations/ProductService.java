package com.unla.grpc.services.implementations;
import com.unla.grpc.converters.DateConverter;
import com.unla.grpc.dtos.ProductDTO;
import com.unla.grpc.models.Product;
import com.unla.grpc.repositories.IProductRepository;
import com.unla.grpc.services.interfaces.IProductService;
import com.unla.retroshopservicegrpc.grpc.ProductResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import java.util.List;

@Service("productService")
public class ProductService implements IProductService {

    ModelMapper modelMapper = new ModelMapper();

    @Autowired
    private IProductRepository productRepository;

    @Autowired
    UserService userService;

    @Override
    public ProductDTO getProduct(Long id) {
        Product aux = productRepository.findById(id).get();
        ProductDTO productDTO = modelMapper.map(aux,ProductDTO.class);
        return productDTO;
    }

    @Override
    public ProductResponse getProductResponseById(long id) {
        ProductDTO productAux = getProduct(id);
        return ProductResponse.newBuilder()
                .setId(productAux.getId())
                .setName(productAux.getName())
                .setDescription(productAux.getDescription())
                .setPrice(productAux.getPrice())
                .setQuantity(productAux.getQuantity())
                .setDate(DateConverter.LocalDate_to_String(productAux.getDate()))
                .setUserResponse(userService.getUserResponseById(productAux.getIdUser()))
                .setCategory(productAux.getCategory())
                .build();
    }
    @Override
    public ResponseEntity<String> saveProduct(ProductDTO product) {
     /*   Optional<User> user = userRepository.findById(product.getIdUser());
        if (user.isPresent()) {*/
            Product aux = modelMapper.map(product, Product.class);
            if (product.getPhotos().size() > 5) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("El producto no fue agregado porque tiene mas de 5 fotos");
            } else if (product.getPhotos().size() < 1) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("El producto no fue agregado porque tiene menos de 1 foto");
            }
            productRepository.save(aux);
            return ResponseEntity.status(HttpStatus.CREATED).body("El producto fue agregado correcatamente");
        /*}else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("El producto no fue agregado porque el usuario no está registrado");
        }*/
    }

    @Override
    public ResponseEntity<String> updateProduct(ProductDTO product,long id) {
        Product aux = modelMapper.map(product, Product.class);
        aux.setId(id);
        productRepository.save(aux);
        return ResponseEntity.status(HttpStatus.OK).body("El producto fue actualizado correctamente");
    }

    @Override
    public List<ProductDTO> getByIdUser(long idUserInProduct) {
        /*ListIterator<Product> productListIterator = productRepository.findByIdUser(idUserInProduct).listIterator();
        Type listType = new TypeToken<List<ProductDTO>>(){}.getType();
        return modelMapper.map(productListIterator, listType);*/
        return null;
    }

    @Override
    public List<ProductDTO> getAllProducts() {
        /*ListIterator<Product> productListIterator = productRepository.findAll().listIterator();
        Type listType = new TypeToken<List<ProductDTO>>(){}.getType();
        return modelMapper.map(productListIterator, listType); */
        return null;
    }

}