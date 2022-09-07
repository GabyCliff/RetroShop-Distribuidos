package com.unla.grpc.models;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity(name = "product")
@Data
public class Product {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String description;

    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> photos;

    @Column
    private float price;

    @Column
    private int available;

   // @DateTimeFormat(pattern = "yyyy-MM-dd")
    //private LocalDate date;

}
