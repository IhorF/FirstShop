package ua.com.library.dto;

public class SeasonDTO {
	private int id;

	private String name;

	public SeasonDTO() {
	}

	public SeasonDTO(int id, String name) {
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
		return "SeasonDTO [id=" + id + ", name=" + name + "]";
	}

	public String getFullSeason() {
		String fullSeason = this.name;

		return fullSeason;
	}

}
