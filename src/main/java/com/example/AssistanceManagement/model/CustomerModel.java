package com.example.AssistanceManagement.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "Costumer")
@NoArgsConstructor
public class CustomerModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Integer customerId;

    @Getter
    @Setter
    private String customerName;
    @Getter
    @Setter
    private String customerSurname;

    @Column(unique = true)
    @Getter
    @Setter
    private String customerEmail;

    @Column(unique = true)
    @Getter
    @Setter
    private String customerPhoneNumber;
    @Getter
    private String customerPassword;
    @Getter
    @Setter
    private String costumerAddress;


}
