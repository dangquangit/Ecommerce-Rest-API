package com.nab.ecommerce.models;

import com.nab.ecommerce.models.audit.DateAudit;
import com.nab.ecommerce.models.product.Product;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "brands")
public class Brand extends DateAudit {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(name = "brand_name")
  private @NotBlank String brandName;

  private @NotBlank String description;

  // add imageURL here

  @OneToMany(mappedBy = "brand", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  public Set<Product> products;

  public Brand() {
  }

  public Brand(@NotBlank String brandName, @NotBlank String description) {
    this.brandName = brandName;
    this.description = description;
  }

  public String getBrandName() {
    return this.brandName;
  }

  public void setBrandName(String brandName) {
    this.brandName = brandName;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Set<Product> getProducts() {
    return products;
  }

  public void setProducts(Set<Product> products) {
    this.products = products;
  }

  @Override
  public String toString() {
    return "User {brand id=" + id + ", brand name='" + brandName + "', description='" + description + "'}";
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }
}