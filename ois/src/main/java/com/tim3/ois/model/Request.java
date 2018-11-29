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
public class Request {
    @Id
    @SequenceGenerator (name = "id_lend", sequenceName = "lend_seq",allocationSize = 1, initialValue= 1)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "id_user")
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "request_by",nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User user;

    @Column(name = "request_date", nullable = false, updatable = false)
    @CreatedDate
    private Date createdAt;

    @Column(name = "return_date")
    private Date returnAt;

    @ManyToMany
    @JoinTable(name = "request_detail", joinColumns =@JoinColumn(name = "request_id"),inverseJoinColumns = {@JoinColumn(name = "item_id"),@JoinColumn(name = "quantity")})
    private Set<Item> items; //terakhir buat sampai sini, database table blum di re-create


}
