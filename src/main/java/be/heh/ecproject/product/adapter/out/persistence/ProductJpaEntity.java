package be.heh.ecproject.product.adapter.out.persistence;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "products")
@Data
public class ProductJpaEntity {

@Id
@GeneratedValue(strategy= GenerationType.AUTO)
@Column(name = "id")
private Long id;

@Column(name = "product_name")
private String productName;

@Column(name = "description")
private String description;

@Column(name = "unit_price")
private double unitPrice;

@Column(name = "image_url")
private String imageUrl;
}
