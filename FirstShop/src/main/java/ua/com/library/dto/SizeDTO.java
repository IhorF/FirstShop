package ua.com.library.dto;

public class SizeDTO {
	private int id;

	private String name;
	
	public SizeDTO() {
	}

	public SizeDTO(int id, String name) {
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
		return "SizeDTO [id=" + id + ", name=" + name + "]";
	}
	
	
	
	
	public String getFullSize() {
		String fullSize=this.name;

	return  fullSize;
	}
	
	
	
	
	
	
	
	
	
	
}
