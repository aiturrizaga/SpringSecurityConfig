package pe.edu.vallegrande.securityrestdemo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
public class Product {

    @Id
    @GeneratedValue
    private Long id;

    @Size(max = 200)
    @NotEmpty(message = "Please enter a name")
    private String name;

    @Size(max = 100)
    @NotEmpty(message = "Please enter a brand")
    private String brand;

    @NotEmpty(message = "Please enter a price")
    private String price;

    @Size(max = 50)
    @NotEmpty(message = "Please enter a category")
    private String category;

    @Size(max = 1)
    @NotEmpty(message = "Please enter a status")
    private String status;

    public Product() {
    }

    public Product(String name, String brand, String price, String category, String status) {
        this.name = name;
        this.brand = brand;
        this.price = price;
        this.category = category;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
