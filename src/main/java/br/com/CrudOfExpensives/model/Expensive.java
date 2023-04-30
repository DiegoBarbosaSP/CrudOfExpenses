package br.com.CrudOfExpensives.model;

import java.time.LocalDate;

public class Expensive {
    private Integer id;
    private String description;
    private LocalDate date;
    private Double value;
    private Category category;


    public Expensive(Integer id, String description, LocalDate date, Double value, Category category) {
        this.id = id;
        this.description = description;
        this.date = date;
        this.value = value;
        this.category = category;
    }

    // getters and setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }


}
