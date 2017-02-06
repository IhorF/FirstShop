package ua.com.library.dto;

public class CommodityDTO {
	private String articul;
	private double price;
	private String pathImage;
	private int id;

	public CommodityDTO() {
	}

	public CommodityDTO(String articul, int id, double price, String pathImage) {
		super();
		this.articul = articul;
		this.id = id;
		this.price = price;
		this.pathImage = pathImage;
	}

	public String getArticul() {
		return articul;
	}

	public void setArticul(String articul) {
		this.articul = articul;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	@Override
	public String toString() {
		return "CommodityDTO [articul=" + articul + ", price=" + price
				+ ", pathImage=" + pathImage + ", id=" + id + "]";
	}

}
