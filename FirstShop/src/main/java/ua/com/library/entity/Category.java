package ua.com.library.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String name;

	@OneToMany(mappedBy = "category")
	private List<Commodity> commodity;

	public Category() {
	}

	public Category(String name) {
		super();
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Commodity> getCommodity() {
		return commodity;
	}

	public void setCommodity(List<Commodity> commodity) {
		this.commodity = commodity;
	}

	public String getFullCategory() {
		String fullCategory = this.name;

		return fullCategory;
	}

	@Override
	public String toString() {
		return "Category: " + name;
	}

}
