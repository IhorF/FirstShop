package ua.com.library.dto;

public class CustomerDTO {
	private int id;
	private String name;
	private String surName;
	private String pathImage;
	
	public CustomerDTO() {
	}

	public CustomerDTO(int id, String name, String surName, String pathImage) {
		super();
		this.id = id;
		this.name = name;
		this.surName = surName;
		this.pathImage = pathImage;
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
	public String getSurName() {
		return surName;
	}
	public void setSurName(String surName) {
		this.surName = surName;
	}

	public String getPathImage() {
		return pathImage;
	}

	public void setPathImage(String pathImage) {
		this.pathImage = pathImage;
	}
	
	
}
