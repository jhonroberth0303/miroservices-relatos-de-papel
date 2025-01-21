package com.unir.ms.commons.models.entity;

import jakarta.persistence.*;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Book")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long isbn;
    private String title;
    private String author;
    private String genre;
    private String editorial;
    private String language;
    private Integer pages;
    private Integer year;
    private String description;
    private Double price = 0.0;
    private String image;
    @Column(name="create_at")
    @Temporal(TemporalType.DATE)
    private Date createAt;

}