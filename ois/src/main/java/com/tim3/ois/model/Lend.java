package com.tim3.ois.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "request")
public class Lend {
    @Id
    @SequenceGenerator (name = "id_lend", sequenceName = "lend_seq",allocationSize = 1, initialValue= 1)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "id_user")
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "user_id",nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User user;

    @Column(name = "requestDate", nullable = false, updatable = false)
    private Date requestDate;

    @Column(name = "returnDate")
    private Date returnDate;

    @ManyToMany
    @JoinTable(name = "request_detail", joinColumns =@JoinColumn(name = "request_id"),inverseJoinColumns = @JoinColumn(name = "item_id"))
    private Set<Item> items;

    @JoinTable(name = "request_detail")
    private int quantity;

}
