package ua.com.library.editor;

import java.beans.PropertyEditorSupport;

import ua.com.library.service.SeasonService;

public class SeasonEditor extends PropertyEditorSupport{
	
	private final SeasonService seasonService;

	public SeasonEditor(SeasonService seasonService) {
		this.seasonService = seasonService;
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		setValue(seasonService.findOne(Integer.parseInt(text)));
	}

}