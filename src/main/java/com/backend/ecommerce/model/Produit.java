package com.backend.ecommerce.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Table(name = "produits")
@Entity
@Getter
@Setter
@ToString
public class Produit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    private @NotNull String nom;
    private @NotNull String imageUrl;
    private @NotNull Float prix;
    private @NotNull String description;

    @CreationTimestamp
    @Column(name="created_at",columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP", nullable = false, updatable = false, insertable = false)
    private Date created_at;
    //Many to one relationship
    @ManyToOne
    @JoinColumn(name = "category_id")
    Category category;

    public void setId(Integer id) {
        this.id = id;
    }
}