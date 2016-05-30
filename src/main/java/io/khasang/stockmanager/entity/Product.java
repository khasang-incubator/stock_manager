package io.khasang.stockmanager.entity;

import javax.persistence.*;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name="user_id_fk")
    private User user;

    @Column
    private String productName;

    @Column
    private String description;

    

}
