package com.unla.grpc.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {

    private Long id;

    private String name;

    private String description;

    private List<String> photos;

    private float price;

    private long quantity;

    private LocalDate date;

    private long idUser;

    private String category;
}