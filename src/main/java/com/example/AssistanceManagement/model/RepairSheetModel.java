package com.example.AssistanceManagement.model;

import com.example.AssistanceManagement.model.Enums.Status;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "RepairSheet")
@NoArgsConstructor
public class RepairSheetModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Integer fileId;

    @Getter
    @Setter
    private Double price;

    @Enumerated(EnumType.STRING)
    @Getter
    @Setter
    private Status repairStatus;
    @Getter
    @Setter
    private String problemDescription;
    @Getter
    @Setter
    private LocalDateTime dateCreated;

    @ManyToOne
    @JoinColumn(name = "personnelId", referencedColumnName = "personnelId")
    @Getter
    @Setter
    private PersonnelModel personnelModel;

    @OneToOne
    @JoinColumn(name = "productId", referencedColumnName = "productSerialNumber")
    @Getter
    @Setter
    private ProductModel productModel;
}
