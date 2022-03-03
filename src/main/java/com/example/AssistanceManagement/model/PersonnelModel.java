package com.example.AssistanceManagement.model;

import com.example.AssistanceManagement.model.Enums.Classification;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "Personnel")
@NoArgsConstructor
public class PersonnelModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Integer personnelId;

    @Enumerated(EnumType.STRING)
    @Getter
    @Setter
    private Classification personnelClassification;

    @Column(unique = true)
    @Getter
    @Setter
    private String personnelEmail;

    @Getter
    @Setter
    private String personnelPassword;

    @ManyToOne
    @JoinColumn(name = "customerId", referencedColumnName = "customerId")
    @Getter
    @Setter
    private CustomerModel customerModel;

}
