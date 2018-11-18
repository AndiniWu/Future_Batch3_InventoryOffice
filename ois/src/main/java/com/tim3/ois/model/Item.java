package com.tim3.ois.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "item")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private int id;

    @Column(name="price")
    @NotEmpty(message = "*Please provide the price")
    private long price;

    @Column(name="quantity")
    @NotEmpty(message = "*Please provide the quantity")
    private int quantity;

    @Column(name="name")
    @NotEmpty(message = "*Please provide the name")
    private String name;

    @Column(name="description")
    @NotEmpty(message = "*Please provide the description")
    private String description;

}


