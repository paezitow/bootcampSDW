package com.santanderdevweek.bootcamp.model;


import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name= "tb_stock")
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name= "id")
    private Long id;

    @Column(name= "nameStock")
    private String nameStock;

    @Column(name= "price")
    private Double price;

    @Column(name= "date")
    private LocalDate dateStock;

    @Column(name= "variation")
    private Double variation;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameStock() {
        return nameStock;
    }

    public void setNameStock(String name) {
        this.nameStock = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public LocalDate getDateStock() {
        return dateStock;
    }

    public void setDateStock(LocalDate dateStock) {
        this.dateStock = dateStock;
    }

    public Double getVariation() { return variation; }

    public void setVariation(Double variation) {
        this.variation = variation;
    }


}
