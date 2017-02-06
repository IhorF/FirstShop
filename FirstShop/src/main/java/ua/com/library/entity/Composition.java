package ua.com.library.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Composition {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "bavovna")
	private String cotton;
	@Column(name = "poliamid")
	private String polyamide;
	@Column(name = "elastan")
	private String lycra;

	@OneToMany(mappedBy = "composition")
	private List<Commodity> commodity;

	public Composition() {
	}

	public Composition(String cotton, String polyamide, String lycra) {
		super();
		this.cotton = cotton;
		this.polyamide = polyamide;
		this.lycra = lycra;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCotton() {
		return cotton;
	}

	public void setCotton(String cotton) {
		this.cotton = cotton;
	}

	public String getPolyamide() {
		return polyamide;
	}

	public void setPolyamide(String polyamide) {
		this.polyamide = polyamide;
	}

	public String getLycra() {
		return lycra;
	}

	public void setLycra(String lycra) {
		this.lycra = lycra;
	}

	public List<Commodity> getCommodity() {
		return commodity;
	}

	public void setCommodity(List<Commodity> commodity) {
		this.commodity = commodity;
	}

	public String getFullComposition() {
		String fullComposition = "bavovna: " + this.cotton + "%, "
				+ "poliamid: " + this.polyamide + "%, " + "elastan: "
				+ this.lycra + "%";

		return fullComposition;
	}

	@Override
	public String toString() {
		return "Composition: bavovna: " + cotton + "%, " + "poliamid: "
				+ polyamide + "%, " + "elastan: " + lycra + "%";
	}

}
