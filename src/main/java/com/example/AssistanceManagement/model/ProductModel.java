package com.example.AssistanceManagement.model;

import com.example.AssistanceManagement.model.Enums.Brand;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "Product")
@NoArgsConstructor
public class ProductModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Integer productSerialNumber;

    @Enumerated(EnumType.STRING)
    @Getter
    @Setter
    private Brand brand;
    @Getter
    @Setter
    private LocalDateTime dateOfPurchase;
    @Getter
    @Setter
    private LocalDateTime warrantyExpiryDate;

    // TODO One to many relation between product and file

}
