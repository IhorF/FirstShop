package ua.com.library.dto;

public class GenderDTO {
	private int id;

	private String name;
	
	public GenderDTO() {
		
	}

	public GenderDTO(int id, String name) {
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
		return "GenderDTO [id=" + id + ", name=" + name + "]";
	}


	public String getFullGender() {
		String fullGender=this.name;

	return  fullGender;
	}

}

