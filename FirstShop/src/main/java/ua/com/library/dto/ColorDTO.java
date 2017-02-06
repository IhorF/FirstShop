package ua.com.library.dto;

public class ColorDTO {
	private int id;

	private String name;

	public ColorDTO() {
	}

	public ColorDTO(int id, String name) {
		super();
		this.id = id;
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

	@Override
	public String toString() {
		return "ColorDTO [id=" + id + ", name=" + name + "]";
	}

	public String getFullColor() {
		String fullColor = this.name;

		return fullColor;
	}

}
