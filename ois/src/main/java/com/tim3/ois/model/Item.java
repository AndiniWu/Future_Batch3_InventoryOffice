package com.tim3.ois.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "item")
public class Item {

    @Id
    @SequenceGenerator (name = "id_seq", sequenceName = "sq50")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "id_seq")
    @Column(name = "user_id")
    private int id;

    @Column(name="price")
    @NotNull(message = "*Please provide the price")
    private long price;

    @Column(name="quantity")
    @NotNull(message = "*Please provide the quantity")
    private int quantity;

    @Column(name="name")
    @NotEmpty(message = "*Please provide the name")
    private String name;

    @Column(name="description")
    @NotEmpty(message = "*Please provide the description")
    private String description;

}


