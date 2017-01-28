package ua.com.library.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Commodity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String articul;
	private double price;
	private String pathImage;

	@ManyToMany
	@JoinTable(name = "customer_commodity", joinColumns = @JoinColumn(name = "commodity_id"), inverseJoinColumns = @JoinColumn(name = "customer_id"))
	private List<Customer> customers;

	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "commodity_color", joinColumns = @JoinColumn(name = "commodity_id"), inverseJoinColumns = @JoinColumn(name = "color_id"))
	private List<Color> colors;
	
		
	@ManyToOne
	private Category category;

	@ManyToOne
	private Composition composition;
	@ManyToOne
	private Season season;
	@ManyToOne
	private Gender gender;
	@ManyToOne
	private Size size;

	
	
	
	public Commodity() {
	}



	public Commodity(String articul, double price, String pathImage) {
		super();
		this.articul = articul;
		this.price = price;
		this.pathImage = pathImage;
	}






	public Commodity(String articul, double price, String pathImage,
			List<Customer> customers, List<Color> colors, Category category,
			Composition composition, Season season, Gender gender, Size size) {
		super();
		this.articul = articul;
		this.price = price;
		this.pathImage = pathImage;
		this.customers = customers;
		this.colors = colors;
		this.category = category;
		this.composition = composition;
		this.season = season;
		this.gender = gender;
		this.size = size;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getArticul() {
		return articul;
	}

	public void setArticul(String articul) {
		this.articul = articul;
	}

	public List<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}

	public List<Color> getColors() {
		return colors;
	}

	public void setColors(List<Color> colors) {
		this.colors = colors;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Composition getComposition() {
		return composition;
	}

	public void setComposition(Composition composition) {
		this.composition = composition;
	}

	public Season getSeason() {
		return season;
	}

	public void setSeason(Season season) {
		this.season = season;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Size getSize() {
		return size;
	}

	public void setSize(Size size) {
		this.size = size;
	}
	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}





	public String getPathImage() {
		return pathImage;
	}





	public void setPathImage(String pathImage) {
		this.pathImage = pathImage;
	}
	
}
