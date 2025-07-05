package com.codewithmosh.store.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "cart")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private UUID id;

    // tell hibernate to ignore this field when generating sql statements
    @Column(name = "date_created", insertable = false, updatable = false)
    private Date dateCreated;

    @OneToMany(mappedBy = "cart", cascade = CascadeType.MERGE)
    private Set<CartItem> productsInCart = new LinkedHashSet<>();
}
