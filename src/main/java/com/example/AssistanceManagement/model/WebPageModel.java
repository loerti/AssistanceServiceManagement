package com.example.AssistanceManagement.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "WebsitePage")
@NoArgsConstructor
public class WebPageModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Integer websiteId;

    @Column(unique = true)
    @Getter
    @Setter
    private String websiteUrl;


    @ManyToOne
    @JoinColumn(name = "customerId", referencedColumnName = "customerId")
    @Getter
    @Setter
    private CustomerModel customerModel;

    @ManyToOne
    @JoinColumn(name = "productId", referencedColumnName = "productSerialNumber")
    @Getter
    @Setter
    private ProductModel productModel;

}
