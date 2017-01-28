package ua.com.library.editor;

import java.beans.PropertyEditorSupport;

import ua.com.library.service.GenderService;

public class GenderEditor extends PropertyEditorSupport{
	
	private final GenderService genderService;

	public GenderEditor(GenderService genderService) {
		this.genderService = genderService;
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		setValue(genderService.findOne(Integer.parseInt(text)));
	}

}