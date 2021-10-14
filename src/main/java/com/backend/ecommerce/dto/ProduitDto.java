package com.backend.ecommerce.dto;


import javax.validation.constraints.NotNull;
import java.time.Instant;
import java.util.Date;

public class ProduitDto {
    //for create it can be optionnal
    //for update we need the id
    private Integer id;
    private @NotNull String nom;
    private @NotNull String imageUrl;
    private @NotNull Float prix;
    private @NotNull String description;
    private @NotNull Integer categoryId;

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    private Date created_at = Date.from(Instant.now());
    public ProduitDto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Float getPrix() {
        return prix;
    }

    public void setPrix(Float prix) {
        this.prix = prix;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }
}
