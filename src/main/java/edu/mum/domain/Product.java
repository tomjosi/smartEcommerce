package edu.mum.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="description")
	private String description;
	
	@Column(name="qty")
	private Integer qty;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="reviewId")
	private List<Review> reviews;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="imageId")
	private List<Image> images;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="categoryId")
	private Category category;
	
	@Column(name="createdDate")
	private LocalDate createdDate;
	
	@Column(name="modifiedDate")
	private LocalDate modifiedDate;
	
	@Column(name="status")
	private String status;
	
	@Column(name="price")
	private double price;
	
	@Transient
	private Long sellerId;
	
	public Product() {
		super();
	}

	public Product(Long id, String name, String description, Integer qty, List<Review> reviews, List<Image> images, Category category,
			LocalDate createdDate, LocalDate modifiedDate, String status, double price) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.qty = qty;
		this.reviews = reviews;
		this.images = images;
		this.category = category;
		this.createdDate = createdDate;
		this.modifiedDate = modifiedDate;
		this.status = status;
		this.price = price;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getQty() {
		return qty;
	}

	public void setQty(Integer qty) {
		this.qty = qty;
	}

	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

	public List<Image> getImages() {
		return images;
	}

	public void setImages(List<Image> images) {
		this.images = images;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public LocalDate getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDate createdDate) {
		this.createdDate = createdDate;
	}

	public LocalDate getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(LocalDate modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

}
