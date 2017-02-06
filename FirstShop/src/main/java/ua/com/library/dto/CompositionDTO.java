package ua.com.library.dto;

public class CompositionDTO {

	private int id;
	private String cotton;
	private String polyamide;
	private String lycra;

	public CompositionDTO() {
	}

	public CompositionDTO(int id, String cotton, String polyamide, String lycra) {
		super();
		this.id = id;
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

	@Override
	public String toString() {
		return "CompositionDTO [id=" + id + ", cotton=" + cotton
				+ ", polyamide=" + polyamide + ", lycra=" + lycra + "]";
	}

	public String getFullComposition() {
		String fullComposition = "bavovna: " + this.cotton + "%, "
				+ "poliamid: " + this.polyamide + "%, " + "elastan: "
				+ this.lycra + "%";

		return fullComposition;
	}

}
