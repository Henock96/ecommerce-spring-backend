package com.backend.ecommerce.model;

import com.google.cloud.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Table(name = "categories")
@AllArgsConstructor
@Entity
@Getter
@Setter
@ToString
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id", nullable = false)
    private int id;

    @Column(name = "nom")
    private @NotBlank String categoryName;

    private @NotBlank String description;
    @Column(name = "image_url")
    private String imageUrl;

    @CreationTimestamp
    @Column(name="created_at",columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP", nullable = false, updatable = false, insertable = false)
    private Date created_at;

    @CreationTimestamp
    @Column(name="update_at", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date update_at;
    public Category() {

    }

    public void setId(Integer id) {
        this.id = id;
    }
}