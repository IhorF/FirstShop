package ua.com.library.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Color {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;

	@ManyToMany
	@JoinTable(name = "commodity_color", joinColumns = @JoinColumn(name = "color_id"), inverseJoinColumns = @JoinColumn(name = "commodity_id"))
	private List<Commodity> commodity;
	public Color() {
	}

	
	public Color(int id, String name, List<Commodity> commodity) {
		super();
		this.id = id;
		this.name = name;
		this.commodity = commodity;
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
	
	
	
	public String getFullColor() {
		String fullColor=this.name;

	return  fullColor;
	}

	@Override
	public String toString() {
		return name;
	}
	
	
	
	
	
	
	
	
	
}
